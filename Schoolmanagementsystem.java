package project;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

// Class for Email details
class Email {
    String email;

    public Email(String email) {
        this.email = email;
    }
}

// Class for Grade details
class Grade {
    String grade;

    public Grade(String grade) {
        this.grade = grade;
    }
}

// Class for Overall Attendance details
class Attendance {
    double overallAttendance;

    public Attendance(double overallAttendance) {
        this.overallAttendance = overallAttendance;
    }
}

// Class for Academic Details
class AcademicDetails {
    String details;

    public AcademicDetails(String details) {
        this.details = details;
    }
}

// Class for Extra Curricular details
class ExtraCurricular {
    String activities;

    public ExtraCurricular(String activities) {
        this.activities = activities;
    }
}

// Class for Department details
class Department {
    String department;

    public Department(String department) {
        this.department = department;
    }
}

// Main Student class that combines all the individual components
class Student {
    String id;
    String name;
    Department department;
    Email email;
    Grade grade;
    Attendance attendance;
    AcademicDetails academicDetails;
    ExtraCurricular extraCurricular;

    public Student(String id, String name, Department department, Email email, Grade grade, Attendance attendance, AcademicDetails academicDetails, ExtraCurricular extraCurricular) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
        this.grade = grade;
        this.attendance = attendance;
        this.academicDetails = academicDetails;
        this.extraCurricular = extraCurricular;
    }
}

public class SchoolManagementSystem extends JFrame {
    private List<Student> students;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;

    public SchoolManagementSystem() {
        students = new ArrayList<>();
        setTitle("School Management System");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Add tabs with panels
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Manage Students", createManageStudentsPanel());
        tabbedPane.addTab("Student Records", createStudentRecordsPanel());
        tabbedPane.addTab("Search Students", createSearchStudentsPanel());  // Added Search Students Tab
        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createManageStudentsPanel() {
        JPanel panel = new JPanel(new GridLayout(10, 2, 10, 10));
        panel.setBackground(new Color(255, 250, 250)); // Light pink background

        // Border for panel
        Border border = BorderFactory.createLineBorder(new Color(255, 105, 180), 3); // Hot pink border
        panel.setBorder(border);

        // Input fields and labels
        JLabel lblID = new JLabel("Student ID:");
        lblID.setForeground(new Color(255, 20, 147)); // Deep pink color
        JTextField txtID = new JTextField();
        JLabel lblName = new JLabel("Name:");
        lblName.setForeground(new Color(255, 20, 147)); // Deep pink color
        JTextField txtName = new JTextField();
        JLabel lblDepartment = new JLabel("Department:");
        lblDepartment.setForeground(new Color(255, 20, 147)); // Deep pink color
        JTextField txtDepartment = new JTextField();
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setForeground(new Color(255, 20, 147)); // Deep pink color
        JTextField txtEmail = new JTextField();
        JLabel lblGrade = new JLabel("Grade:");
        lblGrade.setForeground(new Color(255, 20, 147)); // Deep pink color
        JTextField txtGrade = new JTextField();
        JLabel lblAttendance = new JLabel("Overall Attendance (%):");
        lblAttendance.setForeground(new Color(255, 20, 147)); // Deep pink color
        JTextField txtAttendance = new JTextField();
        JLabel lblAcademicDetails = new JLabel("Academic Details:");
        lblAcademicDetails.setForeground(new Color(255, 20, 147)); // Deep pink color
        JTextField txtAcademicDetails = new JTextField();
        JLabel lblExtraCurricular = new JLabel("Extra Curricular Activities:");
        lblExtraCurricular.setForeground(new Color(255, 20, 147)); // Deep pink color
        JTextField txtExtraCurricular = new JTextField();

        // Buttons
        JButton btnAdd = new JButton("Add Student");
        btnAdd.setBackground(new Color(144, 238, 144)); // Light green button
        btnAdd.setForeground(Color.BLACK);
        JButton btnUpdate = new JButton("Update Student");
        btnUpdate.setBackground(new Color(255, 165, 0)); // Orange button
        btnUpdate.setForeground(Color.BLACK);

        panel.add(lblID);
        panel.add(txtID);
        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblDepartment);
        panel.add(txtDepartment);
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(lblGrade);
        panel.add(txtGrade);
        panel.add(lblAttendance);
        panel.add(txtAttendance);
        panel.add(lblAcademicDetails);
        panel.add(txtAcademicDetails);
        panel.add(lblExtraCurricular);
        panel.add(txtExtraCurricular);
        panel.add(btnAdd);
        panel.add(btnUpdate);

        return panel;
    }

    private JPanel createStudentRecordsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 255, 240)); // Light green background

        tableModel = new DefaultTableModel(new Object[]{"Student ID", "Name", "Department", "Email", "Grade", "Overall Attendance", "Academic Details", "Extra Curricular"}, 0);
        studentTable = new JTable(tableModel);
        studentTable.setBackground(new Color(240, 255, 240));
        studentTable.setForeground(Color.BLACK);
        studentTable.setFont(new Font("Arial", Font.PLAIN, 14));

        panel.add(new JScrollPane(studentTable), BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SchoolManagementSystem app = new SchoolManagementSystem();
            app.setVisible(true);
        });
    }
}
