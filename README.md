# Student-Management-System
This GUI application manages student results. Users can enter student details, add course grades, and view results. It calculates and displays final grades and letter grades based on inputs. Features include student creation, grade addition, result display, and a clear button for resetting the results area.
This program is a graphical user interface (GUI) application for managing student results. Here's a summary of its key features and functionality:

### Purpose
- The application allows users to create student profiles, add course grades, and view results.

### Components

1. **Student Information:**
   - Users can enter student details such as ID, name, and department.
   - A button labeled "Create Student" saves these details and displays a confirmation message.

2. **Course Information:**
   - Users can input course details, including course ID, course name, and two types of grades (e.g., exam and coursework).
   - The "Add Grade" button processes this information, calculates the final grade based on the input grades, and displays the result along with a letter grade.

3. **Results Area:**
   - A large `JTextArea` displays all the actions performed, including created students and added course grades.
   - The results are shown in a scrollable pane with a border titled "Results".

4. **Clearing Data:**
   - The "Clear Sheet" button clears the results area and shows a confirmation message.

### Functional Logic
- **Student Creation:** Adds a student to the results area with their ID, name, and department.
- **Grade Addition:** Converts entered grades to numerical values, calculates the final grade and letter grade, and displays them.
- **Grade Calculation:** Uses a basic grading scale to convert numerical grades into letter grades (A, B, C, etc.).
- **Error Handling:** Includes basic error handling for invalid input, such as non-numeric grades.

### User Interface
- **Layout:** Uses `BorderLayout` and `BoxLayout` to arrange components, with panels and buttons for better organization.
- **Design:** Utilizes `JLabel`, `JTextField`, `JButton`, `JComboBox`, and `JTextArea` to build the user interface.

This application is designed for simplicity and allows basic interaction for managing and displaying student academic results.
