/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.a.l2;

/**
 *
 * @author Andrey
 */

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;
import com.github.javafaker.Faker;

public class OrcArmyApp {
    private JFrame frame;
    private JComboBox<String> tribeCombo;
    private JComboBox<String> typeCombo;
    private JButton createButton;
    private JTree orcTree;
    private DefaultTreeModel treeModel;
    private JPanel infoPanel;
    private DefaultMutableTreeNode root;
    private Map<String, Ork> orcMap = new HashMap<>();
    private Faker faker = new Faker();

    private static final String[] TRIBES = {"Мордор", "Мглистые Горы:", "Дол Гулдур"};
    private static final String[] TYPES = {"Простой", "Лидер", "Разведчик"};

    private JTextArea infoTextArea;
    private JPanel statsPanel;

    public OrcArmyApp() {
        frame = new JFrame("Армия Орков");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLayout(new BorderLayout());

        root = new DefaultMutableTreeNode("Армия Тьмы");
        for (String tribe : TRIBES) {
            root.add(new DefaultMutableTreeNode(tribe));
        }

        treeModel = new DefaultTreeModel(root);
        orcTree = new JTree(treeModel);
        JScrollPane treeScroll = new JScrollPane(orcTree);
        frame.add(treeScroll, BorderLayout.WEST);

        infoPanel = new JPanel(new BorderLayout());

        infoTextArea = new JTextArea();
        infoTextArea.setEditable(false);
        infoTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        infoTextArea.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane textScroll = new JScrollPane(infoTextArea);
        infoPanel.add(textScroll, BorderLayout.CENTER);

        statsPanel = new JPanel();
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
        statsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        infoPanel.add(statsPanel, BorderLayout.SOUTH);

        frame.add(infoPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        tribeCombo = new JComboBox<>(TRIBES);
        typeCombo = new JComboBox<>(TYPES);
        createButton = new JButton("Создать Орка");

        controlPanel.add(new JLabel("Племя:"));
        controlPanel.add(tribeCombo);
        controlPanel.add(new JLabel("Тип:"));
        controlPanel.add(typeCombo);
        controlPanel.add(createButton);
        frame.add(controlPanel, BorderLayout.NORTH);

        createButton.addActionListener(e -> createOrc());

        orcTree.addTreeSelectionListener(e -> {
            TreePath path = e.getPath();
            if (path.getPathCount() == 3) {
                String name = path.getLastPathComponent().toString();
                showOrcInfo(orcMap.get(name));
            }
        });

        frame.setVisible(true);
    }

    private void createOrc() {
        String tribe = (String) tribeCombo.getSelectedItem();
        String type = (String) typeCombo.getSelectedItem();
        String name = faker.lordOfTheRings().character();

        OrcBuilder builder = OrkBuilderFactory.createOrcBuilder(tribe);
        OrcDirector director = new OrcDirector(builder);
        Ork orc;

        switch (type) {
            case "Лидер":
                orc = director.createLeaderOrc(name);
                break;
            case "Разведчик":
                orc = director.createScoutOrc(name);
                break;
            default:
                orc = director.createBasicOrc(name);
        }

        orcMap.put(name, orc);

        DefaultMutableTreeNode tribeNode = findOrCreateTribeNode(tribe);
        DefaultMutableTreeNode orcNode = new DefaultMutableTreeNode(name);
        tribeNode.add(orcNode);
        treeModel.reload();
    }

    private DefaultMutableTreeNode findOrCreateTribeNode(String tribe) {
        Enumeration<TreeNode> children = root.children();
        while (children.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) children.nextElement();
            if (node.getUserObject().equals(tribe)) {
                return node;
            }
        }
        DefaultMutableTreeNode newTribe = new DefaultMutableTreeNode(tribe);
        root.add(newTribe);
        return newTribe;
    }

    private void showOrcInfo(Ork orc) {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ").append(orc.getName()).append("\n");
        sb.append("Племя: ").append(orc.getTribe()).append("\n");
        sb.append("Роль: ").append(orc.getRole()).append("\n\n");
        sb.append("Экипировка:\n");
        sb.append("Оружие: ").append(orc.getWeapon().getName()).append("\n");
        sb.append("Броня: ").append(orc.getArmor().getName()).append("\n");
        sb.append("Знамя: ").append(orc.getBanner().getName()).append("\n");
        infoTextArea.setText(sb.toString());

        statsPanel.removeAll();
        statsPanel.add(createThinStatBar("Сила", orc.getStrength(), 100));
        statsPanel.add(createThinStatBar("Ловкость", orc.getAgility(), 100));
        statsPanel.add(createThinStatBar("Интеллект", orc.getIntelligence(), 50));
        statsPanel.add(createThinStatBar("Здоровье", orc.getHealth(), 200));
        statsPanel.revalidate();
        statsPanel.repaint();
    }

    private JPanel createThinStatBar(String label, int value, int max) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel lbl = new JLabel(label + ":");
        lbl.setPreferredSize(new Dimension(80, 20));

        JProgressBar bar = new JProgressBar(0, max);
        bar.setValue(value);
        bar.setPreferredSize(new Dimension(200, 10));
        bar.setForeground(new Color(60, 179, 113));
        bar.setStringPainted(true);

        panel.add(lbl, BorderLayout.WEST);
        panel.add(bar, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));

        return panel;
    }

}

