# FILE-HANDLING-UTILITY

COMPANY: CODTECH IT SOLUTIONS

NAME: GOWRI SANGEETHA V 

INTERN ID: CT08VKR

DOMAIN: JAVA PROGRAMMING 

DURATION: 4 WEEEKS

MENTOR: NEELA SANTOSH

## Overview  
This Java program demonstrates various file operations, including:  
- Creating a file  
- Writing and appending content  
- Reading file content  
- Renaming a file  
- Copying a file  
- Deleting a file  

It provides a structured and reusable approach to file handling in Java.  

---

## Features  
✔ Create a new file  
✔ Write content to a file (overwrite or append)  
✔ Read a file (entire content or line by line)  
✔ Rename a file  
✔ Copy a file  
✔ Delete a file  

---

## Getting Started  

### Prerequisites  
- Java Development Kit (JDK 8 or later)  
- Any Java-compatible IDE (VS Code, IntelliJ IDEA, Eclipse)  

---

### Installation  
1. Clone this repository:  
   ```sh
   git clone https://github.com/yourusername/java-file-handling.git

2. Navigate to the project directory:

cd java-file-handling

3. Compile the Java program:

javac FileUtil.java

4. Run the Java program:

java FileUtil

Code Explanation

1.Creating a File

FileUtil.createFile("example.txt");
Creates a file named example.txt if it does not already exist.

2.Writing and Appending to a File

FileUtil.writeFile("example.txt", "Hello, File Handling!", false);
FileUtil.writeFile("example.txt", "\nAppending more content.", true);
Writes and appends content to the file.

3.Reading a File

String content = FileUtil

4.Renaming a File

FileUtil.renameFile("example.txt", "renamed_example.txt");
Renames example.txt to renamed_example.txt.

5️.Copying a File

FileUtil.copyFile("renamed_example.txt", "copy_example.txt");
Copies renamed_example.txt to copy_example.txt.

6️.Deleting a File

FileUtil.deleteFile("renamed_example.txt");
FileUtil.deleteFile("copy_example.txt");
Deletes the specified files.

Output Example

File created: example.txt  
Written to file: example.txt  
Appended to file: example.txt  
File content:  
Hello, File Handling!  
Appending more content.  

File content (line by line):  
Hello, File Handling!  
Appending more content.  

File renamed to: renamed_example.txt  
File copied to: copy_example.txt  
File deleted: renamed_example.txt  
File deleted: copy_example.txt


---

Contributing

Contributions are welcome! Feel free to submit a pull request or open an issue
