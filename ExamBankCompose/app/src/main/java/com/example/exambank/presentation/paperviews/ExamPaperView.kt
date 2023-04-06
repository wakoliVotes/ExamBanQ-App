package com.example.exambank.presentation.paperviews

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.exambank.R
import com.example.exambank.ui.theme.black
import com.example.exambank.ui.theme.white
import kotlinx.coroutines.flow.*


class ExamPapersViewModel : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _papers = MutableStateFlow(fullPaperData)

    val papers = searchText
        .combine(_papers) { text, papers ->
            if (text.isBlank()) {
                papers
            } else {
                papers.filter {
                    it.doesMatchSearchuery(text)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _papers.value
        )

    fun onSearchTermChange(text: String) {
        _searchText.value = text
    }
}


data class FullPaperData(
    var unitName: String,
    var academicYear: String,
    var unitCode: String,
    var monthYear: String,

    var questionOne: String,
    var questionTwo: String,
    var questionThree: String,
    var questionFour: String,
    var questionFive: String,
    var questionSix: String,
    var questionSeven: String,
    var questionEight: String,

    var questionNine: String,
    var questionTen: String,
    var questionEleven: String,
    var questionTwelve: String,
    var questionThirteen: String,

    var questionFourteen: String,
    var questionFifteen: String,
    var questionSixteen: String,
    var questionSeventeen: String,
    var questionEighteen: String,

    var questionNineteen: String,
    var questionTwenty: String,
    var questionTwentyOne: String,
    var questionTwentyTwo: String,
    var questionTwentyThree: String,

    var questionTwentyFour: String,
    var questionTwentyFive: String,
    var questionTwentySix: String,
    var questionTwentySeven: String? = null,
    var questionTwentyEight: String? = null,

    var questionTwentyNine: String? = null,
    var questionTwentyThirty: String? = null,

    ) {
    fun doesMatchSearchuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "QUESTION TWO", "QUESTION THREE", "QUESTION FOUR", "QUESTION FIVE",
            "$unitName$unitCode",
            "$unitName $unitCode",
            "${unitName.first()} ${unitCode.first()}"
        )
        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}

val fullPaperData = listOf(
    FullPaperData(
        unitName = "System Development Methodology",
        academicYear = "2018",
        unitCode = "BBIT207",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Operating systems design starts by defining goals and specifications. Briefly describe THREE objectives of modern operating systems design. (3 Marks)",
        questionThree = "b) Give any FOUR functions performed by an operating system (4 Marks)",
        questionFour = "c) Describe the following operating system categories and offer examples:\n" +
                "i) Embedded operating system (2 Marks)\n" +
                "ii) Stand-alone operating system (2 Marks)\n" +
                "iii) Network operating system (2 Marks)",
        questionFive = "d) Differentiate between uniprogramming and multiprogramming and draw a diagram to illustrate each. (6 Marks)",
        questionSix = "e) Describe FOUR cases in which CPU scheduling can happen. (4 Marks)",
        questionSeven = "f) Describe FOUR factors that are considered when deciding a good scheduling algorithm.(4 Marks)",
        questionEight = "g) Briefly explain how context switching occurs in operating systems (3 Marks)",


        questionNine = "QUESTION TWO [20 Marks]",
        questionTen = "a) Explain in detail how the operating system acts as a user-computer interface. (5 Marks)",
        questionEleven = "b) Utilities are specialized programs that make computing easier. Describe any FOUR Windows utilities (4 Marks)",
        questionTwelve = "c) i) What is the difference between a program and a process? (2 Marks)\n" +
                "ii) The operating system is responsible for several activities in connection with process management. Describe any FOUR of these activities (4 Marks)",
        questionThirteen = "d) A process goes through a series of discrete process states. State and explain FIVE states in which it can occur. (5 Marks)",



        questionFourteen = "QUESTION THREE [20 Marks]",
        questionFifteen = "a) Explain the following terms:\n" +
                "i) Job control language (2 Marks)\n" +
                "ii) Distributed computing (2 Marks)\n" +
                "iii) Multi-threaded process (2 Marks)\n" +
                "iv) Race condition (2 Marks)",
        questionSixteen = "b) Distinguish between non-preemptive scheduling and preemptive scheduling and give TWO examples from each (6 Marks)",
        questionSeventeen = "c) Describe any THREE operating systems security threats and offer ONE example for each threat. (6 Marks)",



        questionEighteen = "QUESTION FOUR [20 Marks]",
        questionNineteen = "a) Briefly explain the meaning of the term 'file system' (2 Marks)",
        questionTwenty = "b) In file naming what do the following file extensions stand for? (5 Marks)\n" +
                "i) File.mp3\n" +
                "ii) File.html\n" +
                "iii) File.txt\n" +
                "iv) File.zip\n" +
                "v) File.jpg",
        questionTwentyOne = "c) i) Explain the concept of operating system security (2 Marks)",
        questionTwentyTwo = "ii) Briefly describe the any THREE operating system security goals (3 Marks)",
        questionTwentyThree = "d) State and explain any FOUR layers of I/O software. (8 Marks)",



        questionTwentyFour = "QUESTION FIVE [20 Marks]",
        questionTwentyFive = "a) Computer Software can roughly be divided into TWO forms: system programs and application programs. Briefly discuss these two categories. (4 Marks)",
        questionTwentySix = "b) Briefly explain the meaning of the following concepts in the context of operating systems:\n" +
                "i) Virtual memory (2 Marks)\n" +
                "ii) Shell (2 Marks)\n" +
                "iii) Drivers (2 Marks)",
        questionTwentySeven = "c) State and explain TWO types of file access methods. (4 Marks)",
        questionTwentyEight = "d) Discuss any THREE page replacement algorithms in memory management (6 Marks)",
    ),
    FullPaperData(
        unitName = "Operating Systems",
        academicYear = "2022",
        unitCode = "BAC 1102/BISF 1102/BSD 1105/",
        monthYear = "AUG, 2019",

        questionOne = "QUESTION ONE [30 Marks]",
        questionTwo = "a) Explain TWO main purposes of an operating system. (2 Marks)",
        questionThree = "b) Describe any FOUR attributes that should be considered when designing the file structure for operating system. (4 Marks)",
        questionFour = "c) Describe the following operating system related concepts:\n i) Device controller (2 Marks)\n ii) SMP (2 Marks)\n iii) Spooling (2 Marks)",
        questionFive = "d) Describe the term ‘operating system utilities’ and highlight any FOUR such utilities. (6 Marks)",
        questionSix = "e) Describe what is a ‘real-time system’. Offer its characteristics and where it is most applicable.(5 Marks)",
        questionSeven = "f) Distinguish between logical and physical address space. (4 Marks)",
        questionEight = "g) Outline any THREE advantages of multiprocessor systems over uniprocessor systems. (3 Marks)",

        questionNine = "QUESTION TWO [20 Marks]",
        questionTen = "a) Outline the basic function of paging. (2 Marks)",
        questionEleven = "b) Explain what happens during demand paging. (3 Marks)",
        questionTwelve = "c) i) What are the differences between internal fragmentation and external fragmentation? (4 Marks)\n ii) Explain the ways of overcoming both types of fragmentation in c(i) above. (4 Marks)",
        questionThirteen = "d) Describe the process of dynamic loading and explain how it aids in better memory space utilization.(4 marks)\n \n \n e) Explain how swapping results in better memory management. (3 Marks)",

        questionFourteen = "QUESTION THREE [20 Marks]",
        questionFifteen = "a) What is a process and what are the attributes of a process? (4 Marks)",
        questionSixteen = "b) Explain the following terms with respect to process management:\n i) Thread (2 Marks)\n ii) Interrupt (2 Marks)\n iii) Semaphore (2 Marks)\n iv) Context switching (2 Marks)",
        questionSeventeen = "c) Describe any FIVE examples of process states. (5 Marks)",
        questionEighteen = "d) Describe THREE types of CPU registers in a typical operating system design. (3 Marks)",

        questionNineteen = "QUESTION FOUR [20 Marks]",
        questionTwenty = "a) Explain how a file name EXAMPLEFILE.TXT would appear when viewed under the DOS command console operating in Windows 98. (2 Marks)",
        questionTwentyOne = "b) Describe what is ‘Direct Access Method’ and list its benefits. (5 Marks)",
        questionTwentyTwo = "c) Explain what the following MS-DOS commands will do during file management: (5 Marks)\ni) dir /W\n ii) dir /p\n iii) diskcopy G: H:\n iv) dir /OD\n  v) chkdsk G: /F",
        questionTwentyThree = "d) Give FOUR reasons why Ubuntu is considered ‘safe’ and not prone to viruses. (4 Marks)\n\n e) Explain pros and cons of a command line interface. (4 Marks)",

        questionTwentyFour = "QUESTION FIVE [10 Marks]",
        questionTwentyFive = "a) List and describe the THREE memory allocation algorithms. (6 Marks)",
        questionTwentySix = "b) Assume you have the following jobs to execute with one processor, with the jobs arriving in the order listed here:\ni ===T(pi)\n0 == 80\n1 == 20\n2 == 10\n3 == 20\n4 == 50\ni) Suppose a system uses FCFS scheduling. Create a Gantt chart illustrating the execution of these processes. (2 Marks)\nii) Calculate the average wait time for the processes. (2 Marks)",
        questionTwentySeven = "c) What is a race condition? Give an example. (4 Marks) ",
        questionTwentyEight = "d) Discuss the advantages and disadvantages of user level threads. (6 Marks)",
    ),
    FullPaperData(
        unitName = "Installation and Customization",
        academicYear = "2018",
        unitCode = "BAC 1105/BISF 1105/BSD 1106",
        monthYear = "DEC, 2018",

        questionOne = "a) Describe each of the following types of hard disk interfaces:\n" +
                "i) IDE (2 Marks)\n" +
                "ii) SATA (2 Marks)",
        questionTwo = "b) Discuss any FOUR factors that one should consider before purchasing software (4 Marks)",
        questionThree = "c) i) Explain FOUR reasons why we should maintain computers (4 Marks)" +
                "ii) State THREE computer hardware maintenance practices. (3 Marks)",
        questionFour = "b) Discuss TWO causes of ‘out of memory’ error in relation to computers. (2 Marks)",
        questionFive = "c) Differentiate between a surge protector and a UPS (2 Marks)",
        questionSix = "d) Define the term malware as used in computer. Describe any FOUR ways of preventing computer malware. (5 Marks)",
        questionSeven = "e) Peter replaced a printer cartridge with a new one, but the printer produced distorted printouts. Explain three possible causes for this problem (6 Marks)",

        questionEight = "QUESTION TWO [20 MARKS]",
        questionNine = "a) What is computer Motherboard? List any TWO components attached to it. (3 Marks)",
        questionTen = "b) Mary intends to use a USB port instead of a parallel port to connect peripheral devices on her\n" +
                "computer. Outline any FOUR advantages of USB port that could be influencing her choice\n" +
                " (4 Marks)\n",
        questionEleven = "c) Differentiate between on-board devices and peripheral devices giving TWO examples for each case. (4 Marks)",
        questionTwelve = "d) i) Define the term software and mention TWO main categories of software. (3 Marks)\n" +
                "ii) State and explain THREE ways of fixing software problems in a computer. (6 Marks)\n",
        questionThirteen = "QUESTION THREE [20 MARKS]",
        questionFourteen = "a) Define the following terms and give an example:\n" +
                "i) System software (2 Marks)\n" +
                "ii) Utility software (2 Marks)\n" +
                "iii) Application software (2 Marks)",
        questionFifteen = "b) State and explain FOUR factors that one should consider before purchasing a laptop (4 Marks)",
        questionSixteen = "c) Explain the use of the following types of computer ports: (5 Marks)" +
                "i) VGA port\n" +
                "ii) Ethernet port\n" +
                "iii) DVI port\n" +
                "iv) FireWire port\n" +
                "v) PS/2 port",
        questionSeventeen = "d) Philomena recently noted that some critical documents in her computer were encrypted and\n" +
                "she was forced to pay a certain fee through the Internet to decrypt her files Required:" +
                "i) Identify this type of attack (1 Mark)\n" +
                "ii) Outline any FOUR possible causes for the attack (4 Marks)",

        questionEighteen = "QUESTION FOUR [20 MARKS]",
        questionNineteen = "a) What is the boot order? Briefly Explain (2 Marks)",
        questionTwenty = "b) Explain the process and implication of setting the boot order (4 Marks)",
        questionTwentyOne = "c) Explain the function of each of the following keys during POST process in a computer system:\n" +
                "i) Esc (2 Marks)\n" +
                "ii) F10 (2 Marks)\n" +
                "iii) F12 (2 Marks)",
        questionTwentyTwo = "d) Computer technicians experience several challenges when carrying out routine maintenance. Outline any FOUR challenges that can be experienced (4 Marks)",
        questionTwentyThree = "e) Explain what is BIOS and describe any THREE kinds of BIOS. (4 Marks)",

        questionTwentyFour = "QUESTION FIVE [20 MARKS]",
        questionTwentyFive = "a) Briefly explain the difference between a Graphical User Interface (GUI) and a CommandLine Interface-based operating system. (2 Marks)",
        questionTwentySix = "b) While trying to use MS DOS you encounter the COPY and XCOPY commands. Clearly." +
                "explain when the use of these commands is appropriate. (2 Marks)",
        questionTwentySeven = "c) Explain the difference between installing an operating system and installing an Office Production suite such as MS Office. (6 Marks)",
        questionTwentyEight = "d) What do the following shortcuts or combination keys do while working on a Windowsbased system?\n" +
                " i) Ctrl + Shift + Down Arrow Key (2 Marks)\n" +
                " ii) Windows Key + L (2 Marks)\n" +
                " iii) Ctrl + Alt + Del (2 Marks)\n" +
                " iv) Alt + F4 (2 Marks)",
        questionTwentyNine = "e) Write a simple batch file that will create INST_CUST as a sub-directory in your Desktop\n" +
                "folder, then create TIZI as sub-directory in INST_CUST. After this, copy word document\n" +
                "files from Documents to TIZI (2 Marks)"
    ),
    FullPaperData(
        unitName = "Network Programming/Client-Server Comp",
        academicYear = "2018",
        unitCode = "BAC 2303/BIT 3105/BCT 2203",
        monthYear = "DEC 2018",

        questionOne = "QUESTION ONE [30 MARKS]",
        questionTwo = "(a) Briefly explain why heterogeneity caused by different operating systems and hardware present challenges to distributed application programming. [4 Marks]",
        questionThree = "(b) Identify and briefly discuss any two (2) computing resources that an operating system manages. [4 Marks]",
        questionFour = "(c) List and briefly explain three (3) benefits of middleware to network applications.[6 Marks]",
        questionFive = "(d) Explain why it is necessary to have the source address on an Ethernet frame. [4 Marks]",
        questionSix = "(e) (i) State the similarity between physical and logical addresses. [2 Marks]\n" +
                " (ii) What is the difference between the two? [2 Marks]\n",
        questionSeven = "(f) Define the following terms as they relate to network programming:\n" +
                " (i) port [1 Mark]\n" +
                " (ii) host [1 Mark]\n" +
                " (iii) child process [1 Mark]\n" +
                " (iv) transparency [1 Mark]",
        questionEight = "(g) List and briefly explain any two (2) things a child process inherits from a parent process. [4 Marks]",

        questionNine = "QUESTION TWO [20 MARKS]",
        questionTen = "(a) (i) With an aid of a simple program, explain the concept of tiers. [6 Marks]\n" +
                " (ii) Is your program a “1-Tier”, “2-Tier” or “3-Tier”? Explain. [4 Marks]",
        questionEleven = "(b) What are the entries that make up a half association? Describe them. [6 Marks]\n",
        questionTwelve = "(c) It has been said that flow control and congestion control are equivalent. Is this true for the Internet’s connection-oriented service? Are the objectives of flow control and congestion " +
                "control the same? [4 Marks]",

        questionThirteen = "QUESTION THREE [20 MARKS]",
        questionFourteen = "(a) A middleware provides two (2) forms of distribution transparency. List and discuss them. [4 Marks]",
        questionFifteen = "(b) Extensibility as an attribute of a middleware refers to the ease with which a system can be " +
                "adapted to meet new requirements. List and explain the three (3) types of extensibility. [6 Marks]",
        questionSixteen = "(c) One can not discuss a real data link layer implementation without Ethernet featuring in the " +
                "discussion. Explain the three (3) perspectives of Ethernet in this discussion. [6 Marks]",
        questionSeventeen = "(d) Type of Service and Time-To-Live are two of the many fields of an IP datagram. Briefly explain their function. [4 Marks]",


        questionEighteen = "QUESTION FOUR [20 MARKS]",
        questionNineteen = "KCA University has purchased the Class B IP address 150.5.0.0. The Network Engineer has " +
                "discovered that he needs to create subnets with 100 hosts for the University. You have been assigned " +
                "the task of implementing these subnetworks using the purchased Class B address.",
        questionTwenty = "(a) What is the number of hosts in binary? [2 Marks]",
        questionTwentyOne = "(b) What is the subnet mask for entire network? Show your working. [4 Marks]",
        questionTwentyTwo = "(c) Determine the increment and list the IP address ranges for the first six subnetworks. [6 Marks]",
        questionTwentyThree = "(d) Discuss any four (4) merits of using VLANs in your network. [4 Marks]",
        questionTwentyFour = "(e) Briefly discuss why subnetting is important in distributed systems deployment. [4 Marks]",

        questionTwentyFive = "QUESTION FIVE [20 MARKS]",
        questionTwentySix = "(a) Using the appropriate Network APIs, differentiate between a Client program and a Server program. [6 Marks]",
        questionTwentySeven = "(b) List and breifly explain the two (2) types of TCP segements. [4 Marks]",
        questionTwentyEight = "(c) Using an appropriate diagram, explain how RPC is implemented. [10 Marks]"
    ),

    FullPaperData(
        unitName = "Java Programming",
        academicYear = "2018",
        unitCode = "BIT2204A",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE [30 Marks]",
        questionTwo = "a) Briefly describe three types of programming errors that are encountered in java programming. Write a java code example for each case (6 Marks)",
        questionThree = "b) Briefly explain the following terms in the context Java programming. Write a sample java code\n" +
                "statement for each case\n" +
                "i) Variable (2 Marks)\n" +
                "ii) Identifier (2 Marks)\n" +
                "iii) Assignment operator (2 Marks)\n" +
                "iv) concatenating operator (2 Marks)",
        questionFour = "c). Describe three properties of a ‘constructor’ as used Java programming. Write a sample code that implements a constructor (4 Marks)",
        questionFive = "d) Discuss four features of Java programming language. (4 Marks)",
        questionSix = "e) Write a well commented java program that prompts the user to enter two numbers, evaluates which among the two is higher and prints the results. (4 Marks)",
        questionSeven = "f) Describe the meaning of the term inheritance and write a sample code that demonstrates how it is implemented in java programming (4 Marks)",
        questionEight = "7. What is the difference between a class and an object?",

        questionNine = "QUESTION TWO [20 Marks]",
        questionTen = "The following method was written to determine whether its String parameter reads " +
                "identically left-to-right and right-to-left (the so called palindrome).\n" +
                "boolean isPalindrome(String s) {\n" +
                "int i = 0, j = s.length() - 1;\n" +
                "while (i != j && s.charAt(i) == s.charAt(j)) {\n" +
                "i++;\n" +
                "j--;\n" +
                "}\n" +
                "return (i == j);\n" +
                "}\n" +
                "This method compiles fine, yet unfortunately, the code contains a logic error, which " +
                "may result in a run-time error, or wrong output.\n" +
                "a) Find the error and explain what problem it will cause (2 Marks)",
        questionEleven = "b) Fix the error (write the correct statements) (3 Marks)",
        questionTwelve = "c) Write an alternative, recursive implementation (6 Marks)",
        questionThirteen = "d) What are three benefits which exceptions bring to Object-Oriented Programming? (3 Marks)",

        questionFourteen = "e) Write a program called ExtractDigits to extract each digit from an int, in the reverse order. For example, if the int is 15423, the output shall be \"3 2 4 5 1\", with a space separating the digits. (6 Marks)",


        questionFifteen = "QUESTION THREE",
        questionSixteen = "a) Write a program called Bin2Dec to convert an input binary string into its equivalent decimal number (3 Marks)",
        questionSeventeen = "b) Write a program called GradesAverage, which prompts user for the number of students reads it from the keyboard, and saves it in an int variable called numStudents. It then prompts user for the grades of each of the students and saves them in an int array called grades. Your program shall check that the grade is between 0 and 100. (6 Marks)",
        questionEighteen = "c) Write a method called printArray(), which takes an int array and print its contents in the form of {a1, a2, ..., an} (4 Marks)",
        questionNineteen = "d) Differentiate between the following (4 Marks)\n" +
                "i) Abstract class and Interface\n" +
                "ii) Constructor and a method",
        questionTwenty = "e) Using an example describe the concept of method overloading (3 Marks)\n",


        questionTwentyOne = "QUESTION FOUR [20 Marks]",
        questionTwentyTwo = "a). Write a java program for computing circumference and area of circle. The program should contain the following features (6 Marks)\n" +
                "i. Object\n" +
                "ii. More than one methods\n",
        questionTwentyThree = "b) Create class named House_items that prompts the user to enter three names of three items found in a house, e.g. chair, table, utensils etc a. The features of the program should include the following:\n" +
                "i. Array for storing items entered by the user\n" +
                "ii. For-loop for accessing the array and prints all the items entered by the user (5 Marks)",

        questionTwentyFour = " (c) Differentiate between private and public class. Elaborate with suitable example (3 Marks)",
        questionTwentyFive = " (d) describe the meaning of the term 'bytecode' in the context of java programming (2 Marks)",
        questionTwentySix = "(e) Write while-loop structure using a well commented java programming code that can print the following five numbers (4 Marks)\n" +
                " 1,2,3,4,5",


        questionTwentySeven = "QUESTION FIVE",
        questionTwentyEight = "a) describe the difference between the following control structures and write a sample java code to illustrate your answer.\n" +
                " i) Do-while loop and while loop (4 Marks)\n" +
                " ii) If structure and If/else structure (4 Marks)",
        questionTwentyNine = "b) Create a class named eggs. Its main() method holds an integer variable named numberofeggs to which you will store a value. Create a method to which you pass numberofeggs. The method displays the eggs in dozens. For example, 25 eggs is 2 dozens and 1 left over. (6 Marks)",
        questionTwentyThirty = "c) Write a class named employee, that request an employee to enter the number of hours worked computes total payment using the following formula : (6 Marks)\n" +
                "\n" +
                "Totalpayment=hoursworked*1000.\n" +
                "The program should displays results. For example\n" +
                "Hours worked: 3\n" +
                "Totalpayment : 3000"

    ),
    FullPaperData(
        unitName = "Internet Application Programming",
        academicYear = "2018",
        unitCode = "BBIT 201",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Describe the steps followed in developing a web application. [4 Marks]",
        questionThree = "b) Discuss the two-tier architecture for a web application. [4 Marks]",
        questionFour = "c) Describe any three web technologies 6 Marks",
        questionFive = "d) Explain the difference between the following CSS rules.\n [4 Marks]",
        questionSix = "i. .odd { border: dashed; color:red }\n" +
                "ii. #x { border: dashed; color:blue }",
        questionSeven = "e) Write sample HTML code to create the document below. 8 Marks",

        questionEight = "QUESTION TWO [20 MARKS]",
        questionNine = "a) Write a javaScript program that uses two functions. The first function receives two integers from the user using dialog boxes then passes the values to another function that calculates the product of the two numbers and returns the correct answer to the calling function. 10 Marks",
        questionTen = "b) Describe THREE uses of a form in an online application. 6 Marks",
        questionEleven = "c) Differentiate between GET and POST method values in a form. 4 Marks",

        questionTwelve = "QUESTION THREE [20 MARKS]",
        questionThirteen = "a) Define the concepts of a well-formed XML document, and a valid XML document. 6 Marks",
        questionFourteen = "b) Differentiate between an attribute and an element in HTML. 4 Marks",
        questionFifteen = "c) Write the HTML code to make the word kca an absolute hyperlink to www.kca.ac.kE 5 Marks",
        questionSixteen = "d) Write the CSS code to add a pink background color to a class selector called “drivein\". 5 Marks",

        questionSeventeen = "QUESTION FOUR [20 MARKS]",
        questionEighteen = "a) Write a JavaScript program to receive ten floating point values, store them in an array, then calculate and display their average. 8 Marks",
        questionNineteen = "b) Write a JavaScript program to get the user input for the floor the user wants to go using a lift and displays the appropriate remark using switch case. 8 Marks\n",
        questionTwenty = "c) Describe TWO uses of graphics in a web page.\n" +
                "2 Marks\n",
        questionTwentyOne = "d) Write html tags to display an image stored in the path c:\\Documents\\Folder2\\mypic.gif 2 Marks",


        questionTwentyTwo = "QUESTION FIVE [20 MARKS]",
        questionTwentyThree = "a) Explain the use of marquee element in a web page. 2 Marks",
        questionTwentyFour = "a) Discuss the importance of a DBMS as used in online applications. Hence give two examples of open source DBMS products apart from mySQL. 4 Marks",
        questionTwentyFive = "b) Write a PHP program to calculate and display cost of the products using the formula: Cost=TAX * (quantity*unit price). Assume the TAX is a constant 0.16. The values of quantity and unit price are send as form values to the backend for server side processing. 10 Marks",
        questionTwentySix = "c) Write a PHP program to print even numbers greater than 1 and less than 100 on a web page the browser opens. 4 Marks",
    ),
    FullPaperData(
        unitName = "System Development Methodology",
        academicYear = "2018",
        unitCode = "BBIT207",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Discuss the key drivers of knowledge management (6 Marks)\n",
        questionThree = "b) Describe the approaches to addressing competitive effectiveness using IS/IT (6 Marks)",
        questionFour = "c) Describe the potential benefits and the potential blocks to problem cognition when using techniques in system development (2 Marks)",
        questionFive = "d) Describe THREE barriers to a new business entering an established market according to Michael Porter. (6 Marks)",
        questionSix = "e) Explain what is meant by “iterative prototyping” in the context of systems analysis and design (2 Marks)",
        questionSeven = "f) Define the term information systems development (2 Marks)",
        questionEight = "g) The Human Resources and Finance departments of an organization both use the payroll system. Employees can access the system to look at their pay details and to change their home address. In this context, explain the importance of the qualities of: (6 Marks)",
        questionNine = "i) accessibility\n" +
                "ii) privacy\n" +
                "iii) security",


        questionTen = "QUESTION TWO",
        questionEleven = "a) Compare and contrast any two of the following systems development methodologies based on advantages, disadvantages and phases (provide relevant methodology for each classification ) (14 Marks)",
        questionTwelve = "i. Blended methodologies\n" +
                "ii. Object oriented methodologies\n" +
                "iii. People oriented methodologies\n" +
                "iv. Organisation oriented methodologies\n",
        questionThirteen = "b) Discuss the view that modern life cycle models with their emphasis on prototyping, reate systems that are often fragmented and difficult to integrate; of unsatisfactory reliability, performance, and functionality; and of limited longevity. (6 Marks)",


        questionFourteen = "QUESTION THREE",
        questionFifteen = "a) Describe a methodology which can be considered to reflect the \"science\" paradigm and a methodology which can be considered to reflect the \"systems\" paradigm. Refer to the main objectives, phases/activities, and deliverables of the methodology in your description. Justify your classification of the methodologies. (10 Marks)",
        questionSixteen = "b) A systematic approach to practice, should be used by the ISD professional when developing information systems.",
        questionSeventeen = "i) List and explain THREE overall objectives that should form the framework for systematic practice in the development of an information system. (6 Marks)",
        questionEighteen = "ii) Briefly explain TWO areas where lack of focus by the ISD professional might have undesirable effects on the development of an information system. (4 Marks)",


        questionNineteen = "QUESTION FOUR",
        questionTwenty = "Explain and compare the implications of choosing Object Oriented Systems Development, as opposed to Structured Systems Development, for the following challenges in developing software. Your answer should include discussion of the advantages and disadvantages of each approach for each challenge.",
        questionTwentyOne = "a) Designing the software. (5 Marks)",
        questionTwentyTwo = "b) Producing the software code. (5 Marks)",
        questionTwentyThree = "c) Testing the software product. (5 Marks)",
        questionTwentyFour = "d) Documenting the software process. (5 Marks)",


        questionTwentyFive = "QUESTION FIVE",
        questionTwentySix = "A company has over the years used software development methods that rely on documented specifications and designs. Agile methods are being considered seriously in the pursuit of growth and internationalisation of the business.",
        questionTwentySeven = "a) Explain the agile principles for rapid software development and justify its appropriateness as a method for adoption. (12 Marks)",
        questionTwentyEight = "b) Discuss the view that modern life cycle models with their emphasis on prototyping, create systems that are often fragmented and difficult to integrate; of unsatisfactory reliability, performance, and functionality; and of limited longevity. (8 Marks)",
    ),
    FullPaperData(
        unitName = "Data Warehousing And Data Mining",
        academicYear = "2018",
        unitCode = "BBIT300 BIT3201A",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Define the concept of data warehouse. 2 Marks",
        questionThree = "b) In the context of data warehousing what is data transformation? 2 Marks",
        questionFour = "c) Differentiate between slice and dice operations in OLAP. 4 Marks",
        questionFive = "d) Discuss the characteristics of a data ware house. 4 Marks",
        questionSix = "e) Explain the use of the knowledge base in a data mining system. 4 Marks",
        questionSeven = "f) Differentiate fact table and dimension table. 4 Marks",
        questionEight = "g) Briefly discuss THREE schemas for OLAP systems. 6 Marks",
        questionNine = "h) Differentiate between descriptive and predictive data mining tasks. Give two examples for each. 4 Marks",


        questionTen = "QUESTION TWO [20 MARKS]",
        questionEleven = "a) Briefly describe the cluster analysis as used in data mining. 4 Marks",
        questionTwelve = "b) Explain SIX requirements for cluster analysis. 6 Marks\n",
        questionThirteen = "c) Discuss any FIVE fields where cluster analysis can be applied. 5 Marks",
        questionFourteen = "d) Discuss any FOUR cluster analysis techniques as used in data mining. 5 Marks",


        questionFifteen = "QUESTION THREE [20 MARKS]",
        questionSixteen = "a) Discuss the concept of classification as used in data mining. 4 Marks",
        questionSeventeen = "b) Briefly describe the steps followed classification data mining task. 4 Marks",
        questionEighteen = "c) Discuss any THREE classification techniques in data mining. 9 Marks",
        questionNineteen = "d) Differentiate between data warehouse and operational databases? 3 Marks",


        questionTwenty = "QUESTION FOUR [20 MARKS]",
        questionTwentyOne = "a) Briefly describe the concept of business intelligence. 3 Marks",
        questionTwentyTwo = "b) Explain THREE differences between the OLTP (On-Line Transaction Processing) systems and OLAP (Online Analytical Processing) systems. 6 Marks",
        questionTwentyThree = "c) Discuss at least SIX steps involved in data warehousing. 6 Marks",
        questionTwentyFour = "d) Briefly explain the FIVE primitives for specifying a data mining task. 5 Marks.",

        questionTwentyFive = "QUESTION FIVE [20 MARKS]",
        questionTwentySix = "a) Briefly explain the concept of data scrubbing. 2 Marks",
        questionTwentySeven = "b) Association rules analysis is a technique to uncover how items are associated to each other. There are three common ways to measure association: confidence, support and lift. Study the following transaction table and answer the questions that follow.",
        questionTwentyEight = "TID |  ITEMS\n" +
                "1 |  Apples,Beer,Rice,chicken\n" +
                "2 |  Apples,Beer,Rice\n" +
                "3 |  Apples, Beer\n" +
                "4 |  Apples, Mangoes\n" +
                "5 |  Milk, Beer,Rice,chicken\n" +
                "6 |  Milk,Beer,Rice\n" +
                "7 |  Milk,Beer\n" +
                "8 |  Milk, Mangoes",
        questionTwentyNine = "i. Calculate and explain the confidence of {Apples->Beer} 3 Marks\n" +
                "ii. Calculate and explain the support for apple. 3 Marks\n" +
                "iii. Calculate and explain the lift of {Apple->Beer} 3 Marks",
        questionTwentyThirty = "c) Discuss the role of Apriori principle in association rule mining. 5 Marks\n" +
                "d) Discuss any FOUR dimensions of data quality. 4 Marks",
    ),
    FullPaperData(
        unitName = "Information System Management",
        academicYear = "2018",
        unitCode = "BBIT307",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Distinguish between financial audit and IS audit. [4 Marks]",
        questionThree = "b) Describe Standards, Procedures and Guidelines in ISACA. [6 Marks]",
        questionFour = "c) Discuss the following types of IT audit.",
        questionFive = "i. Integrated Audit\n" +
                "ii. Compliance Audit [4 Marks]",
        questionSix = "d) Explain the following in relation to audit risks.\n" +
                "i. Detection risk\n" +
                "ii. Operational risk [4 Marks]",
        questionSeven = "e) Distinguish between circumstantial and direct types of evidence.\n" +
                "i Direct evidence\n" +
                "ii Indirect evidence [4 Marks]",
        questionEight = "f) Discuss the concept of IT governance and explain any two of its functions. [4 Marks]",
        questionNine = "g) As an IT auditor discuss the main interests you would have in the following phases of systems development.\n" +
                "i. Analysis\n" +
                "ii. Development phase [4 Marks]",


        questionTen = "QUESTION TWO",
        questionEleven = "a) Distinguish the terms Computer forensics and information forensics. [2 Marks]",
        questionTwelve = "b) With the aid of a suitable diagram discuss the general IT audit evidence life cycle which may be adopted when auditing systems. [8 Marks]",
        questionThirteen = "c) Explain the importance of ISACA in IT auditing [4 Mark]",
        questionFourteen = "d) Briefly describe the structure of the COBIT framework. [6 Marks]",


        questionFifteen = "QUESTION THREE",
        questionSixteen = "a) Explain the term Computer Assisted Auditing Techniques (CAATs). [2 Marks]",
        questionSeventeen = "b) Explain the main software tools and techniques available in most CAATs. [4 Marks]",
        questionEighteen = "c) Discuss any three main types of CAATs used in IS auditing procedures. [6 Marks]",
        questionNineteen = "d) Briefly explain the functions of the following online CAATTs.\n" +
                "i. SCARF\n" +
                "ii. BEAST [4 Marks]",
        questionTwenty = "e) Discuss any two code of ethics provided by ISACA [4 Marks]",


        questionTwentyOne = "QUESTION FOUR",
        questionTwentyTwo = "a) Distinguish between dead and live data analysis. [4 Marks]",
        questionTwentyThree = "b) Discuss the following terms used in business criterion in COBIT.\n" +
                "i. Compliance\n" +
                "ii. Integrity\n" +
                "iii. Efficiency [6 Marks]",
        questionTwentyFour = "c) Explain the concept of CSA. [2 Marks]",
        questionTwentyFive = "d) Explain the term work papers and state their relevance in IS auditing. [2 Marks]",
        questionTwentySix = "e) Explain the following types of controls indicating the technical, administrative and physical mechanisms which would be used to realize them in server platforms.\n" +
                "i. Preventative\n" +
                "ii. Detective\n" +
                "iii. Corrective [6 Marks]",


        questionTwentySeven = "QUESTION FIVE",
        questionTwentyEight = "(a) Describe and give an example of each of the following: Contingency planning, Incident response, Disaster Recovery and Business Continuity. With a well labeled diagram, relate the three given above [4 Marks]",
        questionTwentyNine = "b). Discuss in detail the information system audit process. [10 Marks]",
        questionTwentyThirty = "c) An Information system auditor encounters several computer forensic scenarios in the ourse of his work. Discus two common scenarios in the field [2 Marks]",
    ),
    FullPaperData(
        unitName = "Network Installation And Maintenance",
        academicYear = "2018",
        unitCode = "BCT2304",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE",
        questionTwo = "(a) Explain how a Virtual Private Network is implemented. [4 Marks]",
        questionThree = "(b) (i) What are the functions of the Transport and Network Layers of the OSI Model? [4 Marks]",
        questionFour = " (ii) There are three (3) types of domains that a network administrator should worry about namely collision, broadcast and bandwith. Briefly explain what each of these domains are and which devices addresses them. [9 Marks]",
        questionFive = "(c) Routers within the networks of large organisations often learn about connectivity using linkstate protocols. Describe the general behaviour of link-state protocols. [6 Marks]",
        questionSix = "(d) Explain briefly the difference in functionality between the following network troubleshooting\n" +
                "commands:\n" +
                "i. Nslookup and Tracert [2 Marks]\n" +
                "ii. ipconfig /all and getmac [2 Marks]",
        questionSeven = "(e) Which of the following devices can an administrator use to segment their LAN? Choose all that apply and explain the reason for your choice. [3 Marks]\n" +
                "A. Hubs\n" +
                "B. Repeaters\n" +
                "C. Switches\n" +
                "D. Bridges\n" +
                "E. Routers\n" +
                "F. Media Converters",


        questionEight = "QUESTION TWO [20 MARKS]",
        questionNine = "(a) Which of the following are private IP addresses? 10.1.1.1, 172.32.20.55, 192.167.10.10, 172.25.197.250, 224.6.6.6, 192.168.5.5 [3 Marks]",
        questionTen = "(b) State the classes to which IP addresses can be grouped and give the ranges for the first octet decimal values. [5 Marks]",
        questionEleven = "(c) Calculate the number of networks that can be found in Class A, Class B and Class C.[3 Marks]",
        questionTwelve = "(d) Calculate the number of hosts in each Class A network, Class B network. [4 Marks]",
        questionThirteen = "(e) Write the network and broadcast addresses for the IP Address 210.189.137.100 with Subnet Mask – 255.255.255.240 [2 Marks]",
        questionFourteen = "(f) State the ranges of private addresses for Class A, Class B and Class C. [3 Marks]",


        questionFifteen = "QUESTION THREE [20 MARKS]",
        questionSixteen = "(a) (i) Explain the difference that exists between installing a local printer and a network printer. [6 Marks]\n" +
                " (ii) Describe the procedure for installing a network printer in a Windows environment. [6 Marks]",
        questionSeventeen = "(b) Explain how data is transmitted along a fibre optic cable. [6 Marks]",
        questionEighteen = "(c) Briefly explain the difference between Legacy and EFI partition manager. [2 Marks]",
        questionTwenty = "QUESTION FOUR [20 MARKS]",
        questionNineteen = "(a) Give one example of a device on a network that is required to operate all seven layers of the\n" +
                "OSI Reference Model. [2 Marks]",
        questionTwentyOne = "(b) The data link layer in the IEEE standard is divided into two sublayers: LLC and MAC. Indicate the functions performed by each sublayer. [6 Marks]",
        questionTwentyTwo = "(c) A host was given the IP addresses 192.168.3.219 /27. Consider this address and indicate:\n" +
                "i. The network address to which the host belongs. [2 MarkS]\n" +
                "ii. The network broadcast address to which the host belongs. [2 MarkS]\n" +
                "iii. The total number of hosts available in the network [2 MarkS]",
        questionTwentyThree = "(d) Identify three (3) physical characteristics of fibre optic cables that make them more suitable for high speed digital data transmission than copper cables. [6 Marks]",


        questionTwentyFour = "QUESTION FIVE [20 MARKS]",
        questionTwentyFive = "(a) (i) With regard to Windows Server installation, licensing is a vital component. Explain the two (2) main licensing approaches. [4 Marks]",
        questionTwentySix = " (ii) What is the difference between “Role-Based” and “Remote Desktop Management” servers. [4 Marks]",
        questionTwentySeven = "(b) List and briefly discuss any four (4) functions of the NIC. [8 Marks]",
        questionTwentyEight = "(c) What do the following commands do in Linux: [4 Marks]\n" +
                "i. ls -l /etc/samba\n" +
                "ii. ifconfig\n" +
                "iii. ps\n" +
                "iv. grep",
    ),
    FullPaperData(
        unitName = "Computer Organisation And Architecture",
        academicYear = "2018",
        unitCode = "BISF& BSD 1102",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Distinguish between Computer organization and computer architecture (2 Marks)",
        questionThree = "b) What are the essential differences between an assembly language and a high-level language (4 Marks)",
        questionFour = "c) Explain what the role of the operating system is and why it is needed (6 Marks)",
        questionFive = "d) Explain the meaning of the following terms used when describing a computer’s hardware:\n" +
                "i) Temporary memory storage (4 Marks)\n" +
                "ii) Permanent disk storage (4 Marks)",
        questionSix = "e) Perform the following hexadecimal computation\n" +
                "i) 3Fx7E (5 Marks)\n" +
                "ii) FE17+89AB (5 Marks)",


        questionSeven = "QUESTION TWO",
        questionEight = "a) State the importance of the virtual memory in a computer (2 Marks",
        questionNine = "b) Briefly explain the meaning of the following two technologies and provide examples of their application:\n" +
                "i) Bluetooth (3 Marks)\n" +
                "ii) WiFi (3 Marks)",
        questionTen = "c) Describe the following devices:\n" +
                "i) HDMI cable (3 Marks)\n" +
                "ii) USB cable (3 Marks)\n" +
                "iii) LCD projector (3 Marks)\n" +
                "iv) Bar code Scanner (3 Marks)",


        questionEleven = "QUESTION THREE [20 MARKS]",
        questionTwelve = "a) Describe THREE malwares and explain their effects on computer systems (6 Marks)",
        questionThirteen = "b) Explain the attributes found in Fourth generation languages (8 Marks)",
        questionFourteen = "c) Microsoft word has successfully edged out the typewriter. State the functionalities that have made this possible (6 Marks)",


        questionFifteen = "QUESTION FOUR [20 MARKS]",
        questionSixteen = "a) Distinguish between\n" +
                "i) Interpreter and compiler (2 Marks)\n" +
                "ii) Loader and linker (2 Marks)\n" +
                "iii) Accumulator and register (2 Marks)\n" +
                "iv) Utility software and application software (2 Marks)\n" +
                "v) Inkjet and dot matrix printer (2 Marks)",
        questionSeventeen = "b) i) Draw a schematic diagram of a hard disk, naming all the essential components (6 Marks)\n" +
                "iii) Compute the capacity of a hard disk with the following specifications: 5 platters with all sides recordable, 80 tracks per surface of the disk, 128 sectors per surface of the disk and storage density of 512 bytes per sector per track. (Show your workings clearly) (4 Marks)",


        questionEighteen = "QUESTION FIVE [20 MARKS]",
        questionNineteen = "a) Define the term ergonomics and used in computer systems design (2 Marks)",
        questionTwenty = "b) State THREE functions of the CPU (3 Marks)",
        questionTwentyOne = "c) Name THREE main buses found in computer systems (3 Marks)",
        questionTwentyTwo = "d) Distinguish between a graphical user interface and a command line interface and give examples of each (6 Marks)",
        questionTwentyThree = "e) Describe the characteristics of the ROM and give its use (6 Marks)",
        questionTwentyFour = "",
        questionTwentyFive = "",
        questionTwentySix = "",
    ),
    FullPaperData(
        unitName = "Internet Technology",
        academicYear = "2018",
        unitCode = "BIT1102A",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE",
        questionTwo = "a) TCP/IP protocols had several important features that allowed them to meet the need for worldwide data communication. Explain briefly any three of these features. 3 Marks",
        questionThree = "b) Internet access is the ability of individuals and organizations to connect to the Internet using computers and other devices. There are many ways a computer or a terminal can connect to the internet. From this background, compare the following Internet connection types\n" +
                "i. DSL and ISDN\n" +
                "ii. Cable connection and leased line\n",
        questionFour = "c) Briefly discuss the history of the Internet. 5 Marks",
        questionFive = "d) Describe how a computer using DNS resolves the IP address of a domain name. 6 Marks",
        questionSix = "e) Internet is a global network of networks through which computers communicate worldwide. How then does data move around through this global network? The answer is switching. Switching is a process used to forward packets coming in from one port to a port leading towards the destination. From this background discuss the following switching techniques. 4 Marks\n" +
                "i. Circuit switching\n" +
                "ii. Packet switching",
        questionSeven = "f) Internet governance is the development and application of shared principles, norms, rules, decision making procedures, and programs that shape the evolution and use of the Internet. In this context, discuss the main role for each of the following internet governance bodies: 6 Marks\n" +
                "i. the Internet Engineering Task Force (IETF),\n" +
                "ii. the Internet Research Steering Group (IRSG),\n" +
                "iii. the Internet Research Task Force (IRTF).",
        questionEight = "g) Describe three problems that were experienced while using hosts.txt for that mapping host names to the numerical addresses of computers on the ARPANET 6 Marks",


        questionNine = "QUESTION TWO [20 MARKS]",
        questionTen = "a) Discuss the following communication services as used on the Internet: (4Marks)\n" +
                "(i) Weblogs\n" +
                "(ii) Wikis",
        questionEleven = "b) Discuss the difference between classful and classless IP addressing (4 Marks)",
        questionTwelve = "c) State the security challenges of having mobile phones accessing the internet (4 Marks)",
        questionThirteen = "d) Discuss how Network address translation works (4 Marks)",
        questionFourteen = "e) Explain why two different search engines may provide different results when provided with the same search term. (4 Marks)",


        questionFifteen = "QUESTION THREE [20 MARKS]",
        questionSixteen = "a) Describe four Windows TCP/IP utilities used in troubleshooting the internet (include their use) (8 Marks)",
        questionSeventeen = "b) Explain Three-Way Handshake Mechanism used by TCP to terminate a Session reliably. (6 Marks)",
        questionEighteen = "c) Describe the components of the URL using a suitable example (4 Marks)",
        questionNineteen = "d) Identify atleast four port numbers that are useful on the Internet (2 Marks)",


        questionTwenty = "QUESTION FOUR [20 MARKS]",
        questionTwentyOne = "a) Outline the role of protocols as applied to the Internet and name three protocols frequently used on the Internet. (4 Marks)",
        questionTwentyTwo = "b) Explain how the Domain Name System allows computers to contact each other to exchange email or display web pages. (6 Marks)",
        questionTwentyThree = "c) Briefly explain the roles of the following devices (4 Marks)\n" +
                "i. Switch\n" +
                "ii. Router\n" +
                "iii. Hub\n" +
                "iv. Bridge",
        questionTwentyFour = "d) HTTP error codes are three digit numbers with the first digit defining the class of the status code. Explain the following status codes (6 Marks)\n" +
                "i) 2xx\n" +
                "ii) 4xx\n" +
                "iii) 5xx",


        questionTwentyFive = "QUESTION FIVE [20 MARKS]",
        questionTwentySix = "a) Explain the term “ Internet of things”. (4 Marks)",
        questionTwentySeven = "b) Why is the internet based on the client server architecture? (3 Marks)",
        questionTwentyEight = "c) How does the Dynamic host configuration protocol give the IP addresses? (4 Marks)",
        questionTwentyNine = "d) What are the ranges in IPv4 IP classful addressing (5 Marks)",
        questionTwentyThirty = "e) Why is the TCP better than UDP in internetworking (4 Marks)",
    ),
    FullPaperData(
        unitName = "Computer Organisation And Architecture",
        academicYear = "2018",
        unitCode = "BIT 1109/BBIT 102",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Identify the various components of following email address: kansime@yahoo.com. (3 Marks)",
        questionThree = "b) Explain the following disk management operations:\n" +
                "i. Disk defragmentation (2 Marks)\n" +
                "ii. Disk compression (2 Marks)\n" +
                "iii. Disk partitioning (2 Marks)",
        questionFour = "c) Outline FIVE features of first generation computers (5 Marks)",
        questionFive = "d) With relevant examples, distinguish between multiuser and a single user operating system\n" +
                " (4 Marks)\n",
        questionSix = "e) Outline FIVE factors to consider when selecting secondary storage devices. (5 Marks)",
        questionSeven = "f) Highlight THREE features of 3rd generation programming languages. (3 Marks)",
        questionEight = "g) Distinguish between the internet and world wide web. (4 Marks)",


        questionNine = "QUESTION TWO [20 MARKS]",
        questionTen = "a) Table below is an extract of data in a spreadsheet program. Use it to answer the questions that Follow:",
        questionEleven = "1\t|A\t|B\t|C\t|D\t|E\t\n" +
                "2\t|NAME\t|Basic salary\t|House Allowance\t|Medical Allowance\t|Tax\t\n" +
                "3\t|Joseph\t|10000\t|3000|1000\t\n" +
                "4\t|Pius|5000\t|2000\t|500\t\n" +
                "5\t|Betty\t|7000\t|1000\t|400\t\n" +
                "6\t|Joyce\t|4500\t|500\t|300\t|" +
                "7\t|TAX\t|16%",
        questionTwelve = "Using cell addresses only, write a formula that could be used to determine:\n" +
                "i. Tax at 16% of gross pay for joseph (2 Marks)\n" +
                "ii. Total for each column (3 Marks)\n" +
                "iii. Lowest salary (2 Marks)\n" +
                "iv. Highest Salary (1 Mark)\n" +
                "v. Distinguish between relative referencing and absolute referencing. (2 Marks)",
        questionThirteen = "b) Citing examples, discuss how the use of computers have impacted businesses in Kenya. (10 Marks)",


        questionFourteen = "QUESTION THREE [20 MARKS]",
        questionFifteen = "a) The Internet has revolutionized the way businesses are conducted in this century.\n",
        questionSixteen = "i. Explain FIVE benefits of e-commerce to the business. (10 Marks)\n" +
                "ii. Enumerate FOUR benefits of teleworking to an organization. (4 Marks)\n",
        questionSeventeen = "b) Discuss the components of the central processing unit. (6 Marks)",


        questionEighteen = "QUESTION FOUR\n [20 MARKS]",
        questionNineteen = "a) Explain THREE difference between Read Only Memory (ROM) and Random Access Memory (RAM). (3 Marks",
        questionTwenty = "b) Discuss the THREE different types of user interfaces. (6 Marks)\n",
        questionTwentyOne = "c) Varying requirements have led to the development of printers with different capabilities. Discuss the factors that would be considered when purchasing a printer. (10 Marks)",
        questionTwentyTwo = "d) Define a peripheral device as used in computing. (1 Mark)",


        questionTwentyThree = "QUESTION FIVE [20 MARKS]",
        questionTwentyFour = "a) Convert the decimal number 9910 to:\n" +
                "i. Binary (3 Marks)\n" +
                "ii. Octal (2 Marks)\n" +
                "iii. Hexadecimal systems. (2 Marks)\n",
        questionTwentyFive = "b) Describe FIVE categories of application software indicating how they can be utilized in an\n" +
                "organization. (10 Marks)",
        questionTwentySix = "c) Define the following terms as used in word processors:\n" +
                "i. Thesaurus (1 Mark)\n" +
                "ii. Indentation (1 Mark)\n" +
                "iii. Word wrap (1 Mark)",
    ),
    FullPaperData(
        unitName = "Business Communication Skills",
        academicYear = "2018",
        unitCode = "BIT1104A",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Describe how technology affects managerial communication. (5Marks)",
        questionThree = "b) State five active listening behaviors (5Marks)",
        questionFour = "c) Explain the importance of communication in an educational institution. (8Marks)",
        questionFive = "d) Explain how the steps to prepare for a job interview. (10Marks)",
        questionSix = "f) Differentiate between verbal and non-verbal communication. (2Marks)",


        questionSeven = "QUESTION TWO",
        questionEight = "a) Discuss five ways to overcome the barriers to effective interpersonal communication. (10Marks)",
        questionNine = "b) Explain the three benefits of using visual aids in a speech. (6Marks)",
        questionTen = "c) Explain the functions of feedback. (4Marks)",



        questionEleven = "QUESTION THREE",
        questionTwelve = "a) Identify five characteristics of a good report. (5 Marks)",
        questionThirteen = "b) State five qualities of a good meeting and explain how managers can use meetings to motivate staff. (8Marks)",
        questionFourteen = "c) Differentiate between formal and informal channels of communication. (4 Marks)",
        questionFifteen = "d) Explain the significance of sharing in our day to day life. (3 Marks)",


        questionSixteen = "QUESTION FOUR",
        questionSeventeen = "a) Explain the benefits that a manager derives from enhancing effective interpersonal relationships in the organization. (8 Marks)",
        questionEighteen = "b) You are the manager of Classic Enterprises. One of your valued customers has written you a letter complaining about delivery of defective goods. Write a reply. (8 Marks)",
        questionNineteen = "c) Explain a good or bad customer care experience you had at KCA University. (4 Marks)",


        questionTwenty = "QUESTION FIVE",
        questionTwentyOne = "a) Give any three methods that can be used in solving a conflict. (6 Marks)",
        questionTwentyTwo = "b) Write an essay on the positive and negative effects of the social media among the youth. (10 Marks)",
        questionTwentyThree = "c) Why is it important for managers to understand different cultural backgrounds of the employees? (4 Marks)",
        questionTwentyFour = "",
        questionTwentyFive = "",
        questionTwentySix = "",
    ),
    FullPaperData(
        unitName = "System Development Methodology",
        academicYear = "2018",
        unitCode = "BBIT207",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE",
        questionTwo = "",
        questionThree = "",
        questionFour = "",
        questionFive = "",
        questionSix = "",
        questionSeven = "",
        questionEight = "",
        questionNine = "",
        questionTen = "",
        questionEleven = "",
        questionTwelve = "",
        questionThirteen = "",
        questionFourteen = "",
        questionFifteen = "",
        questionSixteen = "",
        questionSeventeen = "",
        questionEighteen = "",
        questionNineteen = "",
        questionTwenty = "",
        questionTwentyOne = "",
        questionTwentyTwo = "",
        questionTwentyThree = "",
        questionTwentyFour = "",
        questionTwentyFive = "",
        questionTwentySix = "",
        questionTwentySeven = "",
        questionTwentyEight = "",
        questionTwentyNine = "",
        questionTwentyThirty = "",
    ),
    FullPaperData(
        unitName = "Fundamentals of Web Design",
        academicYear = "2018",
        unitCode = "BSD1204",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE",
        questionTwo = "(a) Describe each of the following terms as used in Internet:- [5 Marks]\n" +
                "(i) Hypertext\n" +
                "(ii) Browser\n" +
                "(iii)Web content\n" +
                "(iv)Website\n" +
                "(v) Web page",
        questionThree = "(b) Explain four advantages of HTML over other web authoring tools [4 Marks]",
        questionFour = "(c) Write HTML code that would generate a form when ran on a web browser. The form contains Name, Address, Town/City, Post Code, check section, i.e., \"Is the address also your invoice address? YES or NO\", Submit and Reset buttons- [7 Marks]\n",
        questionFive = "(d) Distinguish between the following terms:- [4 Marks]\n" +
                "(i) Static website & dynamic website\n" +
                "(ii) Web authoring tools and programming tools",
        questionSix = "(e) Outline four differences between Java programming language and Java scripting language [4 Marks]",
        questionSeven = "(f) Outline three uses of HTML tables [3 Marks]\n",
        questionEight = "(g) Outline the function of each of the following tags in HTML:- [3 Marks]\n" +
                "(i) <font>\n" +
                "(ii) <body>\n" +
                "(iii)<sub>",


        questionNine = "QUESTION TWO [20 MARKS]",
        questionTen = "(a) Write TML code that will display a frame with three rows of size 16%, 56% and 45% with\n" +
                "the first showing the content of file1.html, second showing the content of the file2.html and\n" +
                "third showing the content of the file3.html. [6 Marks]\n",
        questionEleven = "(b) Giving appropriate examples explain four types of websites [4 Marks]",
        questionTwelve = "(c) Discuss four factors to consider while designing and implementing websites [4 Marks]",
        questionThirteen = "(d) Explain three lists supported by HTML [6 Marks]",


        questionFourteen = "QUESTION THREE [20 MARKS]",
        questionFifteen = "(b) Write HTML code that will display a table for Orientation Schedule when ran via a web browser. Table must contains Title in CAPS, 3 COLUMNS for start Time, venue and Guest. Add rows with time differences of 2 hour, i..e, 8.00am, 10.00am, 12.am. [6 Marks]",
        questionSixteen = "(c) Write a JavaScript program that would prompt the user to enter two numbers. The program should then find the sum of the user entered numbers and display the results on an alert box. [6 Marks]",
        questionSeventeen = "(d) Explain four factors to consider while selecting an ISP for hosting a website [4 Marks]",
        questionEighteen = "(a) With the aid of an example, explain the components of a Uniform Resource Locator (URL) 5 Marks]",
        questionNineteen = "(b) Outline three image file extensions supported by HTML [3 Marks]",
        questionTwenty = "(c) Explain three forms of website maintenance [3 Marks]",
        questionTwentyOne = "(d) Outline three limitations of HTML [3 Marks]",
        questionTwentyTwo = "(e) Briefly explain the following request methods used by the web browser to access\n" +
                "information from an HTML form\n" +
                "(i) POST method [3 Marks]\n" +
                "(ii) GET method [3 Marks]",


        questionTwentyThree = "QUESTION FIVE [20 MARKS]",
        questionTwentyFour = "(a) Explain the following HTML terms:-\n" +
                "(i) HTML tag [2 Marks]\n" +
                "(ii) HTML element [2 Marks]",
        questionTwentyFive = "(b) Discuss the following types of servers:- [3 Marks]\n" +
                "(i) Web server\n" +
                "(ii) DNS server\n" +
                "(iii)Proxy server",
        questionTwentySix = "(c) Briefly explain how a web browser fetches and displays the webpage contents [4 Marks]",
        questionTwentySeven = "(d) Give three examples of web authoring tools [3 Marks]",
        questionTwentyEight = "(e) Explain the functions of any three IMG tag attributes supported by HTML [6 Marks]",
    ),
    FullPaperData(
        unitName = "Computational Thinking Theory",
        academicYear = "2018",
        unitCode = "BSD1208 ",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Define the following terms (5 Marks)\n" +
                "i) Computation:\n" +
                "ii) Thinking:\n" +
                "iii) Computational Thinking\n" +
                "iv) Algorithm\n" +
                "v) Computer programming",
        questionThree = "b) Explain the FIVE approaches to Computational Thinking (10 Marks)",
        questionFour = "c) Explain FOUR of the basic Computational thinking concepts (8 Marks)",
        questionFive = "d) A program is to read payroll records that includes; employee-number, monthly basic " +
                "salary, monthly house allowance, monthly medical allowance, and monthly tax rate, " +
                "Construct a Input Process Output(IPO) to compute and display his/her employee-number " +
                "monthly basic salary, monthly house allowance, monthly medical allowance, and monthly " +
                "tax rate, and his/her monthly net income. Where; " +
                " monthly net income = (basic salary + house allowance + medical allowance )- (basic" +
                "salary X tax rate) (7 Marks)",


        questionSix = "QUESTION TWO",
        questionSeven = "a) i) Differentiate between Critical Thinking and Creative Thinking AND state the elements of each (6 Marks)\n" +
                "ii) Describe FOUR Positive Attitudes that Lead to Creativity (8 Marks)",
        questionEight = "b) Construct a problem analysis chart (PAC) to compute and display the total surface area of " +
                "a solid cuboid after receiving it length, width, and height of the cuboid from the user " +
                "Total Area = 2(lw + lh + wh) (6 Marks)",


        questionNine = "QUESTION THREE",
        questionTen = "a) Explain FOUR characteristics of a good algorithm (8 Marks)",
        questionEleven = "b) Describe the following concepts with respect to algorithm analysis (4 Marks)\n" +
                "i) Time complexity\n" +
                "ii) Space complexity",
        questionTwelve = "c) Construct an algorithm in form of flowchart to depict the logic of the solution to the\n" +
                "following problem (8 Marks)\n" +
                "A program is required that will captures the name and the rank status(ordinary employee " +
                "or supervisor) of 30 employee of a company as input and then calculate and displays their " +
                "gross income. " +
                "The gross income is calculated on the basis of a basic salary of Ksh.18000.00 by default, " +
                "plus an allowance is applied to it based on the following status criteria; " +
                " Ordinary employee gets 15% of the basic salary " +
                " supervisor get 22 % of the basic salary.",


        questionThirteen = "QUESTION FOUR",
        questionFourteen = "a) With aid of well labeled diagram explain the steps in designing and implementing an algorithm (14 Marks)",
        questionFifteen = "b) Construct a problem analysis chart (PAC) that asks a user to enter the distance of a trip in " +
                "Km, the Km per Litter estimate for the user’s car, and the average cost of a Litter of fuel. " +
                "Calculate and display the number of Litters of fuel needed and the estimated cost of the trip. (6 Marks)",



        questionSixteen = "QUESTION FIVE",
        questionSeventeen = "a) With the aid of diagrams, discus the three types of program execution controls available in " +
                "a structured programming language (9 Marks)",
        questionEighteen = "b) Write down an algorithmic pseudo-code and draw a corresponding flowchart to receive\n" +
                "three numbers one-by-one, find and print the largest of three numbers (11 Marks)",
        questionNineteen = "",
        questionTwenty = "",
        questionTwentyOne = "",
        questionTwentyTwo = "",
        questionTwentyThree = "",
        questionTwentyFour = "",
        questionTwentyFive = "",
        questionTwentySix = "",
    ),
    FullPaperData(
        unitName = "Mobile Computing",
        academicYear = "2018",
        unitCode = "BAC3115",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Discuss the Wireless networks in comparison to fixed networks 8 Marks",
        questionThree = "b) Explain the effects of multipath propagation of signals 6 Marks",
        questionFour = "c) Elaborate some of the motivations of TDMA (Time Division Multiple Access) 6 Marks",
        questionFive = "d) Discuss the characteristics of wireless LAN 6 Marks",
        questionSix = "e) Describe how CSMA/CA works 4 Marks",

        questionSeven = "QUESTION TWO\n",
        questionEight = "a) What are the design goals of wireless LAN 8Marks\n",
        questionNine = "b) Discuss the Euclidean Unit Disk Graph as used in mobile computing 6 Marks",
        questionTen = "c) What are the requirements for Mobile IP 6 Marks",

        questionEleven = "QUESTION THREE",
        questionTwelve = "a) Discuss the characteristics of Dynamic Host Configuration Protocol (DHCP) 6Marks",
        questionThirteen = "b) Discuss the Advantages and Disadvantages Indirect TCP 6 Marks",
        questionFourteen = "c) Describe the following terms as used in mobile computing 8 Marks",
        questionFifteen = "i) Mobile Node (MN)",
        questionSixteen = "ii) Home Agent (HA)",
        questionSeventeen = "iii) Foreign Agent (FA)",
        questionEighteen = "iv) Care-of Address (COA)",

        questionNineteen = "QUESTION FOUR",
        questionTwenty = "a). Using function examples, describe several types of WML Script main libraries 8 Marks",
        questionTwentyOne = "b). Discuss some of application scenarios of mobile computing 8 Marks",
        questionTwentyTwo = "c). Discuss the properties of Inhibit Sense Multiple Access (ISMA) 4 Marks",

        questionTwentyThree = "QUESTION FIVE [20 MARKS]",
        questionTwentyFour = "a) Discuss performance characteristics and disadvantages of GSM 8 Marks",
        questionTwentyFive = "b) Discuss Cocktail party as analogy for multiplexing 6 Marks",
        questionTwentySix = "c) Using a diagram describe format and content of a frame 6 Marks",

        ),
    /*
    FullPaperData(
        unitName = "Mobile Computing",
        academicYear = "2018",
        unitCode = "BAC3115",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Discuss the Wireless networks in comparison to fixed networks 8Marks\n",
        questionThree = "",
        questionFour = "",
        questionFive = "",
        questionSix = "",
        questionSeven = "",
        questionEight = "",
        questionNine = "",
        questionTen = "",
        questionEleven = "",
        questionTwelve = "",
        questionThirteen = "",
        questionFourteen = "",
        questionFifteen = "",
        questionSixteen = "",
        questionSeventeen = "",
        questionEighteen = "",
        questionNineteen = "",
        questionTwenty = "",
        questionTwentyOne = "",
        questionTwentyTwo = "",
        questionTwentyThree = "",
        questionTwentyFour = "",
        questionTwentyFive = "",
        questionTwentySix = "",
        questionTwentySeven = "",
        questionTwentyEight = "",
        questionTwentyNine = "",
        questionTwentyThirty = "",
        ),
     */

    FullPaperData(
        unitName = "Operating Systems",
        academicYear = "2019",
        unitCode = "BSC 201",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE [30 Marks]",
        questionTwo = "1. What is the difference between a class and an object?",
        questionThree = "2. What is the difference between a class and an object?",
        questionFour = "3. What is the difference between a class and an object?",
        questionFive = "4. What is the difference between a class and an object?",
        questionSix = "5. What is the difference between a class and an object?",
        questionSeven = "6. What is the difference between a class and an object?",
        questionEight = "7. What is the difference between a class and an object?",

        questionNine = "QUESTION TWO [20 Marks]",
        questionTen = "8. What is the difference between a class and an object?",
        questionEleven = "9. What is the difference between a class and an object?",
        questionTwelve = "10. What is the difference between a class and an object?",
        questionThirteen = "11. What is the difference between a class and an object?",

        questionFourteen = "QUESTION THREE [20 Marks]",
        questionFifteen = "12. What is the difference between a class and an object?",
        questionSixteen = "13. What is the difference between a class and an object?",
        questionSeventeen = "14. What is the difference between a class and an object?",
        questionEighteen = "15. What is the difference between a class and an object?",

        questionNineteen = "QUESTION FOUR [20 Marks]",
        questionTwenty = "16. What is the difference between a class and an object?",
        questionTwentyOne = "17. What is the difference between a class and an object?",
        questionTwentyTwo = "18. What is the difference between a class and an object?",
        questionTwentyThree = "19. What is the difference between a class and an object?",

        questionTwentyFour = "QUESTION FIVE [10 Marks]",
        questionTwentyFive = "20. What is the difference between a class and an object?",
        questionTwentySix = "21. What is the difference between a class and an object?",
        questionTwentySeven = "22. What is the difference between a class and an object?",
        questionTwentyEight = "23. What is the difference between a class and an object?",
    ),
    FullPaperData(
        unitName = "Computer Networks",
        academicYear = "2019",
        unitCode = "BSC 201",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE [30 Marks]",
        questionTwo = "1. What is the difference between a class and an object?",
        questionThree = "2. What is the difference between a class and an object?",
        questionFour = "3. What is the difference between a class and an object?",
        questionFive = "4. What is the difference between a class and an object?",
        questionSix = "5. What is the difference between a class and an object?",
        questionSeven = "6. What is the difference between a class and an object?",
        questionEight = "7. What is the difference between a class and an object?",

        questionNine = "QUESTION TWO [20 Marks]",
        questionTen = "8. What is the difference between a class and an object?",
        questionEleven = "9. What is the difference between a class and an object?",
        questionTwelve = "10. What is the difference between a class and an object?",
        questionThirteen = "11. What is the difference between a class and an object?",

        questionFourteen = "QUESTION THREE [20 Marks]",
        questionFifteen = "12. What is the difference between a class and an object?",
        questionSixteen = "13. What is the difference between a class and an object?",
        questionSeventeen = "14. What is the difference between a class and an object?",
        questionEighteen = "15. What is the difference between a class and an object?",

        questionNineteen = "QUESTION FOUR [20 Marks]",
        questionTwenty = "16. What is the difference between a class and an object?",
        questionTwentyOne = "17. What is the difference between a class and an object?",
        questionTwentyTwo = "18. What is the difference between a class and an object?",
        questionTwentyThree = "19. What is the difference between a class and an object?",

        questionTwentyFour = "QUESTION FIVE [10 Marks]",
        questionTwentyFive = "20. What is the difference between a class and an object?",
        questionTwentySix = "21. What is the difference between a class and an object?",
        questionTwentySeven = "22. What is the difference between a class and an object?",
        questionTwentyEight = "23. What is the difference between a class and an object?",
    ),
    FullPaperData(
        unitName = "Cyber Security",
        academicYear = "2018",
        unitCode = "BAC2316",
        monthYear = "DEC, 2018",

        questionOne = "QUESTION ONE [30 Marks]",
        questionTwo = "a) Discuss how cryptanalysis techniques are facilitated (5 Marks)",
        questionThree = "b) Discuss Secure Electronic Transaction(SET) process (6 Marks)",
        questionFour = "c) Explain the challenges associated with intrusion detection systems (5 Marks)",
        questionFive = "d) Elaborate on any the laws addressing cybercrime (6 Marks)",
        questionSix = "e) Explain in detail how Secure Socket layer work (8 Marks)",



        questionSeven = "QUESTION TWO [20 MARKS]",
        questionEight = "a) Describe the operating principles of malwares that attack cyber (6 Marks)",
        questionNine = "b) Describe how the various types of firewalls work (8 Marks)",
        questionTen = "c) What is war dialing for remote connectivity? Explain the software used for war dialing (8 Marks)",


        questionEleven = "QUESTION THREE [20 MARKS]",
        questionTwelve = "a) Describe the concepts used in the Anomaly intrusion detection system (6 Marks)",
        questionThirteen = "b) Explain the various tools and technologies used for hacking (8 Marks)",
        questionFourteen = "c) Discuss how Advanced Persistent threats affects the web access (6 Marks)\n",

        questionFifteen = "QUESTION FOUR",
        questionSixteen = "a) Describe the different types of VPN indicating their importance (8 Marks)",
        questionSeventeen = "b) List and explain any two password management practices (6 Marks)",
        questionEighteen = "c) Describe the process of investigating cybercrime (6 Marks)",

        questionNineteen = "QUESTION FIVE [20 Marks]",
        questionTwenty = "a) Using examples discuss how cloud computing and mobile computing threats have become a challenge to cyber security (8 Marks)",
        questionTwentyOne = "b) What is VOIP hacking? Explain the counter measures for it (8 Marks)",
        questionTwentyTwo = "c) Explain any two tools used to check for cybercrime vulnerabilities (4 Marks)",
        questionTwentyThree = "",

        questionTwentyFour = "",
        questionTwentyFive = "",
        questionTwentySix = "",
    )
)


@Preview
@Composable
fun ExamPaperView() {
    val viewModel = viewModel<ExamPapersViewModel>()
    val papers = viewModel.papers.collectAsState()
    val searchText = viewModel.searchText.collectAsState()
    val isSearching = viewModel.isSearching.collectAsState()

    LazyColumn() {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp, top = 16.dp, bottom = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append("Explore ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    Color.Red
                                )
                            ) {
                                append("Papers ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    Color.DarkGray
                                )
                            ) {
                                append("2018")
                            }
                        },
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(start = 8.dp),
                        fontSize = 24.sp,
                        fontFamily = FontFamily.Monospace
                    )
                    Image(
                        painter = painterResource(id = R.drawable.workspaces),
                        contentDescription = null,
                        modifier = Modifier
                            .height(30.dp)
                            .padding(end = 16.dp, top = 8.dp)
                    )
                }
            }
        }
        item {
            // Search TextField
            OutlinedTextField(
                value = searchText.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.LightGray,
                    focusedLabelColor = Color.Gray,
                    unfocusedLabelColor = Color.Gray,
                    cursorColor = Color.LightGray,
                ),
                onValueChange = { /*TODO*/
                    viewModel.onSearchTermChange(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, bottom = 4.dp)
//                    .align(Alignment.CenterHorizontally)
                    .size(55.dp),
                textStyle = TextStyle(
                    color = MaterialTheme.colors.onSecondary
                ),
                label = {
                    Text(
                        text = "Search",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search",
                        tint = Color.Gray
                    )
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Text
                ),
            )
            // End of Search TextField
        }
        items(fullPaperData) { fullPaperData ->
            PaperExpanded(fullPaperData = fullPaperData,
                navHostController = rememberNavController())
        }
    }
}


@Composable
fun PaperExpanded(
    fullPaperData: FullPaperData,
    navHostController: NavHostController,
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .clickable {
                isExpanded = !isExpanded
            }
    ) {
        Row(
            modifier = Modifier
                .padding(start = 16.dp, top = 4.dp, end = 16.dp)
                .fillMaxWidth()
                .height(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            Text(
                text = fullPaperData.unitName,
                modifier = Modifier.padding(),
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                )
            )
            IconButton(
                modifier = Modifier
                    .size(24.dp)
                    .background(Color.Black, CircleShape)
                    .clip(CircleShape)
                    .padding()
                    .rotate(if (isExpanded) 180f else 0f),
                onClick = {
                    /*TODO*/
                    isExpanded = !isExpanded
                }) {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(),
                    tint = if (isExpanded) Color.Red else Color.White
                )
            }
        }
        if (isExpanded) {
            // start of column
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                // Header items card
                Card(

                    shape = RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp),
                    backgroundColor = Color.White,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .height(330.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.kcau),
                            contentDescription = null,
                            modifier = Modifier
                                .clip(CircleShape)
                                .height(100.dp)
                                .width(120.dp),
                            contentScale = ContentScale.Crop

                        )
                        Row(

                            modifier = Modifier.padding(top = 0.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "UNIVERSITY EXAMINATIONS ${fullPaperData.academicYear}",
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily.SansSerif,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "EXAMINATION FOR THE DEGREE OF BACHELOR OF\n" +
                                            "SCIENCE IN INFORMATION TECHNOLOGY/ BACHELOR \n" +
                                            "OF BUSINESS IN INFORMATION TECHNOLOGY",
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily.SansSerif,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = fullPaperData.unitCode + ": " + fullPaperData.unitName,
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily.SansSerif,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center
                                    )
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "FULL TIME/PART TIME/DISTANCE LEARNING",
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily.SansSerif,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Row(
                                    modifier = Modifier.padding(bottom = 5.dp),
                                    horizontalArrangement = Arrangement.SpaceAround
                                ) {
                                    Text(
                                        text = "DATE: ${fullPaperData.monthYear}",
                                        style = TextStyle(
                                            color = Color.Black,
                                            fontSize = 14.sp,
                                            fontFamily = FontFamily.SansSerif,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    Spacer(modifier = Modifier.width(100.dp))
                                    Text(
                                        text = "TIME: 2 HOURS",
                                        style = TextStyle(
                                            color = Color.Black,
                                            fontSize = 14.sp,
                                            fontFamily = FontFamily.SansSerif,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                // 1st Divider
                                Box(

                                    modifier = Modifier
                                        .height(2.dp)
                                        .fillMaxWidth()
                                        .background(color = Color.Black)
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                // INSTRUCTIONS
                                Row(
                                    modifier = Modifier
                                        .padding(bottom = 5.dp)
                                        .fillMaxWidth()
                                        .height(40.dp),
                                    horizontalArrangement = Arrangement.SpaceAround,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "INSTRUCTIONS: ",
                                        style = TextStyle(
                                            color = Color.Black,
                                            fontSize = 12.sp,
                                            fontFamily = FontFamily.SansSerif,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    Text(

                                        text = "Answer Question One & ANY OTHER TWO",
                                        style = TextStyle(
                                            color = Color.Black,
                                            fontSize = 12.sp,
                                            fontFamily = FontFamily.SansSerif
                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                // 2nd Divider
                                Box(

                                    modifier = Modifier
                                        .height(2.dp)
                                        .fillMaxWidth()
                                        .background(color = Color.Black)
                                )
                            }
                        }
                    }
                }
                // TO DO - ADD OTHER QUESTIONS
                // End of header items card and start of question list
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionOne,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionTwo,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionThree,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionFour,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionFive,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionSix,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionSeven,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionEight,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionNine,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionTen,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionEleven,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionTwelve,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionThirteen,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionFourteen,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionFifteen,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionSixteen,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionSeventeen,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionEighteen,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionNineteen,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionTwenty,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionTwentyOne,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionTwentyTwo,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionTwentyThree,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionTwentyFour,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionTwentyFive,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionTwentySix,
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    fullPaperData.questionTwentySeven?.let {
                        Text(
                            modifier = Modifier
                                .padding(8.dp),
                            text = it,
                            color = black,
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Normal
                            )
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    fullPaperData.questionTwentyEight?.let {
                        Text(
                            modifier = Modifier
                                .padding(8.dp),
                            text = it,
                            color = black,
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Normal
                            )
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    fullPaperData.questionTwentyNine?.let {
                        Text(
                            modifier = Modifier
                                .padding(8.dp),
                            text = it,
                            color = black,
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Normal
                            )
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 0.dp, start = 4.dp, end = 4.dp, top = 0.dp)
                        .background(color = white)
                ) {
                    fullPaperData.questionTwentyThirty?.let {
                        Text(
                            modifier = Modifier
                                .padding(8.dp),
                            text = it,
                            color = black,
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Normal
                            )
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp, start = 4.dp, end = 4.dp)
                        .background(color = white)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.Center),
                        text = "...... END ......",
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }
        }
    }
}


