import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Student {
    private String studentID;
    private String name;
    private String department;

    public Student(String studentID, String name, String department) {
        this.studentID = studentID;
        this.name = name;
        this.department = department;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}

class Course {
    private String courseID;
    private String courseName;
    private int creditHours;

    public Course(String courseID, String courseName, int creditHours) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.creditHours = creditHours;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }
}

class Results {
    private double grade1;
    private double grade2;
    private double total;

    public Results(double grade1, double grade2) {
        this.grade1 = grade1;
        this.grade2 = grade2;
    }

    public double getGrade1() {
        return grade1;
    }

    public double getGrade2() {
        return grade2;
    }

    public double finalGrade() {
        total = (grade1 + grade2) / 2;
        return total;
    }

    public String letterGrade() {
        if (total > 85) {
            return "A+";
        } else if (total > 75 && total <= 85) {
            return "A";
        } else if (total > 65 && total <= 75) {
            return "B+";
        } else if (total > 60 && total <= 65) {
            return "B";
        } else if (total > 55 && total <= 60) {
            return "C+";
        } else if (total > 50 && total <= 55) {
            return "C";
        } else if (total > 40 && total <= 50) {
            return "C-";
        } else {
            return "D";
        }
    }
}

class MyFrame extends JFrame implements ActionListener {
    JLabel title, stuID, stuName, department;
    JPanel titlePanel, mainPanel, coursePanel, createPanel, buttonPanel, studentPanel, resultPanel;
    JTextField stuIDField, nameField, courseIDField, courseNameField, gradeField1, gradeField2;
    JButton create, add, clear;
    JTextArea resultArea;
    JScrollPane scrollPane;
    Results result;
    JComboBox<String> departmentBox;

    public MyFrame() {
        titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titlePanel, BorderLayout.NORTH);

        title = new JLabel("Student Result Management System", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(title, BorderLayout.CENTER);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        add(mainPanel, BorderLayout.CENTER);

        studentPanel = new JPanel();
        studentPanel.setLayout(new GridLayout(4, 2, 5, 5));
        mainPanel.add(studentPanel);

        stuID = new JLabel("Student ID : ");
        studentPanel.add(stuID);
        stuIDField = new JTextField(20);
        studentPanel.add(stuIDField);

        stuName = new JLabel("Student Name : ");
        studentPanel.add(stuName);
        nameField = new JTextField(20);
        studentPanel.add(nameField);

        department = new JLabel("Department : ");
        studentPanel.add(department);
        departmentBox = new JComboBox<>(new String[]{"Department of IT","Department of Business & Management","Department of LAW","Department of BIO Medical","Department of Engineering"});
        studentPanel.add(departmentBox);

        createPanel = new JPanel();
        createPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        create = new JButton("Create Student");
        create.setBackground(new Color(66, 133, 244));
        create.setForeground(Color.WHITE);
        create.addActionListener(this);

        createPanel.add(create);
        mainPanel.add(createPanel);

        coursePanel = new JPanel();
        coursePanel.setLayout(new GridLayout(4, 2, 5, 5));
        mainPanel.add(coursePanel);

        coursePanel.add(new JLabel("Course name :"));
        courseIDField = new JTextField(20);
        coursePanel.add(courseIDField);

        coursePanel.add(new JLabel("Module Name :"));
        courseNameField = new JTextField(20);
        coursePanel.add(courseNameField);

        coursePanel.add(new JLabel("Exam result :")); 
        gradeField1 = new JTextField(20);
        coursePanel.add(gradeField1);

        coursePanel.add(new JLabel("Coursework result :")); 
        gradeField2 = new JTextField(20);
        coursePanel.add(gradeField2);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        add = new JButton("Add Grade");
        add.setBackground(new Color(66, 133, 244));
        add.setForeground(Color.WHITE);
        add.addActionListener(this);

        buttonPanel.add(add);
        mainPanel.add(buttonPanel);

        clear = new JButton("Clear Sheet");
        clear.setBackground(new Color(255, 0, 0));
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);

        resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout(10, 10));
        resultArea = new JTextArea();
        scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Results"));
        resultPanel.add(scrollPane, BorderLayout.CENTER);
        resultPanel.add(clear, BorderLayout.SOUTH);
        mainPanel.add(resultPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create) {
            String studentID = stuIDField.getText();
            String name = nameField.getText();
            String department = (String) departmentBox.getSelectedItem();
            resultArea.append("Student Created: " + name + " (" + studentID + ") " + "\n" + department + "\n");
            JOptionPane.showMessageDialog(null, "Student added successfully", "Successful", JOptionPane.INFORMATION_MESSAGE);
            stuIDField.setText("");
            nameField.setText("");
        }

        if (e.getSource() == add) {
            String courseID = courseIDField.getText();
            String courseName = courseNameField.getText();
            String grade1Text = gradeField1.getText();
            String grade2Text = gradeField2.getText();

            //here we get this method from w3 school due to we got some errors to converting string value to double value 
            try {
                double grade1 = Double.parseDouble(grade1Text);
                double grade2 = Double.parseDouble(grade2Text);
        
                result = new Results(grade1, grade2);
                double finalGrade = result.finalGrade();
                String letterGrade = result.letterGrade();
                resultArea.append("Course Added : " + courseID + " - " + courseName + "\nPaper exam marks: " + grade1 + "\nCoursework Marks: " + grade2 + "\nTotal Grade: " + String.format("%.2f", finalGrade) + "\nLetter Grade: " + letterGrade + "\n");
            }
             catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter grades.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }

            courseIDField.setText("");
            courseNameField.setText("");
            gradeField1.setText("");
            gradeField2.setText("");
        }

        if (e.getSource() == clear) {
            resultArea.setText("");
            JOptionPane.showMessageDialog(null, "Result Area cleared ", "Successful", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setTitle("Student Result Management System");
        frame.setVisible(true);
        frame.setSize(500, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
