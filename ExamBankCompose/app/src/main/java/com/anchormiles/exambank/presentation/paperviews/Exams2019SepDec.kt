package com.anchormiles.exambank.presentation.paperviews

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
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
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
import com.anchormiles.exambank.R
import com.anchormiles.exambank.ui.theme.black
import com.anchormiles.exambank.ui.theme.white
import kotlinx.coroutines.flow.*


class Exams2019SepDecViewModel : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _papers = MutableStateFlow(fullPaperData2019)

    val papers = searchText
        .combine(_papers) { text, papers ->
            if (text.isBlank()) {
                papers
            } else {
                papers.filter {
                    it.doesMatchSearchQuery (text)
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


data class FullPaperData2019(
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
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$unitName$unitCode",
            "$unitName $unitCode",
            "${unitName.first()} ${unitCode.first()}"
        )
        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}

val fullPaperData2019 = listOf(
    FullPaperData2019(
        unitName = "Operating Systems",
        academicYear = "2019",
        unitCode = "BAC 1102/BISF 1102/BSD 1105/",
        monthYear = "August, 2019",

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
    FullPaperData2019(
        unitName = "Installation And Customization",
        academicYear = "2018",
        unitCode = "BAC 1105/BISF 1105/BSD 1106: BAC 1105/BISF 1105/BSD 1106",
        monthYear = "AUGUST, 2019",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Explain the purpose of the following features when installing computer memory:\nRAM notch \n Retaining clips ",
        questionThree = "b) Differentiate between headless installation and silent installation as used in software installation",
        questionFour = "c) William suspects that the processor of his computer is failing. Suggest in SIX steps how to replace the faulty processor.",
        questionFive = "d) Outline any SIX criteria that could be used for selecting a computer application package.",
        questionSix = "e) Write a simple batch file that will create INST_CUST as a sub-directory in your Desktop folder, then create TIZI as sub-directory in INST_CUST. After this, copy word document files from Documents to TIZI",
        questionSeven = "f) What is a virtual machine? List and briefly explain the reasons behind virtualization in Installation and Customization.",
        questionEight = "g) Give the DOS command that you would use to hide the contents of the Download folder.",


        questionNine = "QUESTION TWO",
        questionTen = "a) Distinguish between the following computer hardware components: \\nTransistors and capacitors\\nSouth bridge and north bridge \\nMain memory and auxiliary memory.",
        questionEleven = "b) Many computer users have shifted from the liquid crystal display (LCD) monitors to the relatively new organic light emitting diode (OLED) monitors. Suggest THREE reasons for this shift.",
        questionTwelve = "c) i) List THREE internal parts of a disk \\nii) Analyze FOUR methods for determining the speed of a computer hard disk",
        questionThirteen = "d) Identify the unit used to measure each of the following: \\nProcessor speed \\nMonitor resolution\\nMemory size.",


        questionFourteen = "QUESTION THREE [20 MARKS]",
        questionFifteen = "a) Briefly describe the steps that you would follow in installing vlc media player.[6 Marks]",
        questionSixteen = "d) Give the appropriate Linux commands for carrying out the tasks given below:\n" +
                "i) Create a user student2 [2 Marks]\n" +
                "ii) Give student2 a password [2 Marks]\n" +
                "iii) Compressing all files that start with the letters sh in the /etc directory [2 Marks]\n" +
                "iv) Hide a directory called notes in /home/student2 [2 Marks]\n" +
                "v) Starting the Graphical User Interface from the shell. [2 Marks]",
        questionSeventeen = "c) What is the difference between installation of a Server OS and Stand-Alone OS? [4 Marks]",


        questionEighteen = "QUESTION FOUR",
        questionNineteen = "a) Define the following types of software installation:\n" +
                "i) Media based software installation [2 Marks]\n" +
                "ii) Web based software installation [2 Marks]\n" +
                "iii) Single exe installation [2 Marks]\n" +
                "iv) Windows installer installation [2 Marks]",
        questionTwenty = "b) Identify FOUR types of cards that can be added to a computer to enhance its capabilities. [4 Marks]",
        questionTwentyOne = "c) Outline THREE ways of controlling heat inside the system unit. [3 Marks]",
        questionTwentyTwo = "d) Pre-installation system preparation and application testing are important aspects of the software\n" +
                "installation process.\n" +
                "Required\n" +
                "Identify any FIVE tasks that should be undertaken as part of this process. [5 Marks]",


        questionTwentyThree = "QUESTION FIVE [20 MARKS]",
        questionTwentyFour = "a) Distinguish between primary partition and extended partition [2 Marks]",
        questionTwentyFive = "b) Discuss how you would install and configure the following:\n" +
                "i. RAM\n" +
                "ii. Processor\n" +
                "iii.CD-ROM Drive [9 Marks]",
        questionTwentySix = "c) Musa wants to buy a laptop computer. As his computer advisor, describe the features that " +
                "you would give him on how to select the best laptop. [5 Marks]",
        questionTwentySeven = "d) Describe the following microprocessor’s operating modes\n" +
                "i). Real mode\n" +
                "ii). Protected mode [4 Marks]",
    ),
    FullPaperData2019(
        unitName = "Advanced Application Programming",
        academicYear = "2019",
        unitCode = "BAC2308",
        monthYear = "AUGUST, 2019",

        questionOne = "QUESTION ONE (30 MARKS) COMPULSORY",
        questionTwo = "a) Write a function in VB.net that can be used to calculate the balance (change) to be given back to a customer after purchasing goods in store. The purchase should include at least 5 items. 15 Marks",
        questionThree = "b) Write a program that can be used to call the above function and display amount given, total purchased and change to be given in VB.net 5 Marks",
        questionFour = "c) Briefly describe the terms below\n" +
                "(i) Option strict\n" +
                " (ii) Parse\n" +
                " (iii) Explicit Declaration 6 Marks",
        questionFive = "d) VB has two different types of constants describe them using examples 4 Marks",


        questionSix = "QUESTION TWO (20 MARKS)",
        questionSeven = "Roberta must decide which courses to register for in the upcoming semester. She has a\n" +
                "part-time job and is waiting to find out how many hours per week she will be working\n" +
                "during the semester.\n" +
                "· If she works 10 hours (or less) per week, she will register for three classes.\n" +
                "· If she works more than 10 hours per week she will register for only two classes.\n" +
                "· If she receives the scholarship for which she has applied, she will quit her job and\n" +
                "take five classes.\n" +
                "Hours worked is entered into a TextBox control named HoursTextBox. A CheckBox\n" +
                "control named ScholarshipCheckBox will be checked if she gets the scholarship. Display\n" +
                "the number of classes for which she will register to a TextBox control\n" +
                "named NumberOfClassesTextBox.",


        questionEight = "QUESTION THREE (20 MARKS)",
        questionNine = "a) i) Define the VB intelligence 2 Marks\n" +
                " ii) Explain why you would prefer it for typing code to an ordinary text editor\n" +
                "4 Marks",
        questionTen = "b) Explain what is accomplished by the code statements below\n" +
                "Dim MyVariable as String\n" +
                "MyVariable = Combobox1.Text\n" +
                "MsgBox MyVariable 6 Marks",
        questionEleven = "c) Define a module. Visual Basic stores code in three different modules. List and explain\n" +
                "these modules. 8 Marks",


        questionTwelve = "QUESTION FOUR (20MARKS)",
        questionThirteen = "a) Write a programme that does the following:\n" +
                "1. Asks users to enter a number between 10 and 20.\n" +
                "2. The number will be entered into the Textbox.\n" +
                "3. When the Button is clicked, your Visual Basic code will check the number\n" +
                "entered in the Textbox.\n" +
                "4. If it is between 10 and 20, then a message will be displayed.\n" +
                "5. The message box will display the number from the Textbox.\n" +
                "6. If the number entered is not between 10 and 20 then the user will be invited to try\n" +
                "again, and whatever was entered in the Textbox will be erased\n" +
                "10 Marks",
        questionFourteen = "b) Add a Combo box and another button to your form. Create a list of items for your\n" +
                "Combo Box. The list of items in your Combo box can be anything you like - pop\n" +
                "groups, football teams, favourite foods, anything of your choice. Then try the\n" +
                "following:\n" +
                "Use a select case statement to test what a user has chosen from your drop-down\n" +
                "list. Give the user a suitable message when the button was clicked.\n" +
                "10 Marks",


        questionFifteen = "QUESTION FIVE (20 MARKS)",
        questionSixteen = "a) Using examples to illustrate describe the use of the Globalization enumeration method in Vb.net",
        questionSeventeen = "b) Describe using an example in VB the use of ToUpper and Tolower methods 6 Marks",
        questionEighteen = "c) Using sample VB code declare a module-level array and store values to the array immediately. 8 Marks",
        questionNineteen = "",
        questionTwenty = "",
        questionTwentyOne = "",
        questionTwentyTwo = "",
        questionTwentyThree = "",
        questionTwentyFour = "",
        questionTwentyFive = "",
        questionTwentySix = "",
    ),
    FullPaperData2019(
        unitName = "Operating Systems",
        academicYear = "2019/2020",
        unitCode = "BSD 1104",
        monthYear = "AUGUST, 2019",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Explain two basic purposes of Operating System. (4 marks)",
        questionThree = "b) Define batch systems. (2 marks)",
        questionFour = "c) Explain thrashing and its cause. (3 marks)",
        questionFive = "d) Define the virtual memory? What are its advantages? (5 marks)",
        questionSix = "e) Explain demand paging and its use (4 marks)",
        questionSeven = "f) List the advantages of Contiguous allocation (3 marks)",
        questionEight = "g) Differentiate between Logical and physical address (3 marks)",
        questionNine = "h) Differentiate between Segmentation and paging storage (3 marks)",
        questionTen = "i) Explain three activities that an Operating System does to file management (3 marks) ",


        questionEleven = "QUESTION TWO",
        questionTwelve = "a) Explain the common strategies to select a free hole from a set of available holes (6 marks)",
        questionThirteen = "b) Explain the methods used to prevent deadlocks (8 marks)",
        questionFourteen = "c) Explain three stages of scheduling (6 marks)",


        questionFifteen = "**QUESTION THREE**",
        questionSixteen = "a) Explain the requirements that a solution to the critical section problem must satisfy (6 marks)",
        questionSeventeen = "b) Give the condition necessary for a deadlock situation to arise? (4 marks)",
        questionEighteen = "c) Explain the different accessing methods of a file (6 marks)",
        questionNineteen = "d) Distinguish external fragmentation from internal fragmentation. (4 marks)",

        questionTwenty = "QUESTION FOUR",
        questionTwentyOne = "a) Briefly explain process lifecycle. (10 marks)",
        questionTwentyTwo = "b) Explain why an Operating System would terminate a process. (6 marks)",
        questionTwentyThree = "c) Distinguish between hard real-time system and soft real-time system (4 marks)",


        questionTwentyFour = "QUESTION FIVE",
        questionTwentyFive = "a) Define process synchronization (2 marks)",
        questionTwentySix = "b) Explain four types of CPU scheduling. (8 marks)",
        questionTwentySeven = "c) Write short notes on the following: (10 marks)\n" +
                "i. Cooperating process\n" +
                "ii. Independent process\n" +
                "iii. Race condition\n" +
                "iv. Critical section\n" +
                "v. Semaphore",
    ),
    FullPaperData2019(
        unitName = "Expert Systems",
        academicYear = "2019/2020",
        unitCode = "BIT 4405",
        monthYear = "AUGUST, 2019",

        questionOne = "QUESTION ONE",
        questionTwo = "a) What kind of mistakes might ES make and why? (4 Marks)",
        questionThree = "b) Why is it easier to correct mistakes in ES than in conventional programs? (2 Marks)",
        questionFour = "c) Identify the generic categories of expert systems applications (12 Marks)",
        questionFive = "d) Describe the motivation for developing expert systems (4 Marks)",
        questionSix = "e) It is said that powerful computers, inference capabilities, and problem-solving heuristics are necessary but not sufficient for solving real problems. Why? (4 Marks)",
        questionSeven = "f) Distinguish between forward chaining and backward chaining (4 Marks)",


        questionEight = "QUESTION TWO",
        questionNine = "a) Define an Expert system (2 Marks)",
        questionTen = "b) List the major components of an expert system (10 Marks)",
        questionEleven = "c) What are the major difficulties in developing Expert systems? (4 Marks)",
        questionTwelve = "d) Define the ES development environment and contrast it with the consultation\n" +
                "environment. (4 Marks)",


        questionThirteen = "QUESTION THREE",
        questionFourteen = "a) Distinguish between Expert systems and Decision support systems (4 Marks) ",
        questionFifteen = "b) Describe the major limitations of expert systems (12 Marks)",
        questionSixteen = "c) Why is speech recognition and understanding useful? (4 Marks)",


        questionSeventeen = "QUESTION FOUR",
        questionEighteen = "a) Given the current status of the Web, discuss how it is changing the availability of ES and how it is being used to embed expertise in other systems. (10 Marks)",
        questionNineteen = "b) What is the purpose of conducting a Turing test (3 Marks)",
        questionTwenty = "c) Explain the term inferencing as used in expert systems (3 Marks)",


        questionTwentyOne = "QUESTION FIVE",
        questionTwentyTwo = "a) Explain the role of the expert systems and their potential benefits. (8 Marks)",
        questionTwentyThree = "b) List FIVE major Artificial Intelligence Technologies (5 Marks)",
        questionTwentyFour = "c) Explain the role of a knowledge engineer (4 Marks)",
        questionTwentyFive = "d) What are the major activities performed in the ES blackboard (workplace)?(3 Marks)",
        questionTwentySix = "",
    ),
    FullPaperData2019(
        unitName = "Expert Systems",
        academicYear = "2018/2019",
        unitCode = "BIT 4405",
        monthYear = "AUGUST, 2019",

        questionOne = "QUESTION ONE",
        questionTwo = "a) What is an Expert System? 2 Marks",
        questionThree = "b) Advantages of Expert Systems over Human Experts 6 Marks",
        questionFour = "c) Define an Inference Engine used as part of an Expert System 4 Marks",
        questionFive = "d) Examine the contents of the Knowledge Base 4 Marks",
        questionSix = "e) Using examples differentiate between Forward and Backward Chaining  6 Marks",
        questionSeven = "f) How can Linguists help in the development of Expert Systems? 4 Marks.",
        questionEight = "g) Explain the following concepts 4 Marks\n" +
                "i) The Turing Test\n" +
                "ii) Artificial Intelligence\n" +
                "iii) LISP\n" +
                "iv) Speech Recognition Software",


        questionNine = "QUESTION TWO",
        questionTen = "a) Describe the main parts of an expert system. Show how they interact with one another",
        questionEleven = "b) Using two brief examples of knowledge representation, explain how knowledge may be represented in the knowledge base 6 Marks",
        questionTwelve = "c) Describe the advantages and disadvantages of an expert system 4 Marks",
        questionThirteen = "d) Why is MYCIN considered important in the development of expert systems and how did it lead to EMYCIN? 4 Marks",


        questionFourteen = "QUESTION THREE",
        questionFifteen = "a) What is the main purpose of Expert Systems? 4 Marks",
        questionSixteen = "b) What is the main difference between conventional computer programs and production systems (rule based systems)? 5 Marks",
        questionSeventeen = "c) Why is a production system model was used to implement the first rule based expert systems?   5 Marks",
        questionEighteen = "d) What types of knowledge are used by neural networks and by rule based systems? What kinds of systems are they with respect to the type of knowledge they use? 6 Marks",


        questionNineteen = "QUESTION FOUR",
        questionTwenty = "a) Describe the phases of designing an expert system? What term is used to call the whole process?   6 Marks",
        questionTwentyOne = "b) What are the main areas of application of expert systems? 8 Marks",
        questionTwentyTwo = "c) Why is knowledge acquisition often referred to as the ES `bottleneck'? 6 Marks",


        questionTwentyThree = "QUESTION FIVE",
        questionTwentyFour = "a) Why do many people say they will not trust a `robo-doc' medical diagnosis expert system?    8 Marks",
        questionTwentyFive = "b) Describe at least 3 advantages that expert systems offer organisations that would otherwise have to employ human experts. 8 Marks",
        questionTwentySix = "c) Examine any two artificial intelligence techniques used in expert systems 4 Marks",
    ),
    FullPaperData2019(
        unitName = "Assembly Programming",
        academicYear = "2018/2019",
        unitCode = "BAC3115",
        monthYear = "AUGUST.2019 ",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Explain two advantages and two advantages of assembly language.4 Marks",
        questionThree = "b) Describe the following concepts as used in assembly language programming.\n" +
                "i. Mnemonic\n" +
                "ii. Opcode\n" +
                "iii. Operand         3 Marks",
        questionFour = "c) List and explain any THREE control/status registers. 3 Marks",
        questionFive = "d) List and explain any TWO user-visible registers.  2 Marks",
        questionSix = "e) Describe the following types of assembly languages. 4 Marks\n" +
                "i. CISC Assembly language\n" +
                "ii. RISC Assembly language",
        questionSeven = "f) Differentiate between one-pass and two-pass assemblers.  4 Marks",
        questionEight = "g) Describe any THREE functions of an assembler.  6 Marks",
        questionNine = "h) For each of the following assembly statements, state and explain the address modes used. 4 Marks\n" +
                "i. MOV ECX,[EBX+EDI+20]\n" +
                "ii. MOV EAX,406",


        questionTen = "QUESTION TWO [20 MARKS]",
        questionEleven = "a) State and explain THREE keywords used in assembly language    3 Marks",
        questionTwelve = "b) Differentiate between numeric and symbolic labels in assembly language   4 Marks.",
        questionThirteen = "c) Differentiate between integer constants and integer expressions in assembly language. 2 Marks",
        questionFourteen = "d) Briefly explain the format of an assembly language program. 5 Marks",
        questionFifteen = "e) Brief state and explain any THREE assembly language directives 6 Marks",


        questionSixteen = "QUESTION THREE [20 MARKS]",
        questionSeventeen = "a) Write a simple assembly language program to add two binary numbers 1010b and 1100b   6 Marks",
        questionEighteen = "b) Write a simple assembly language program to multiply two real numbers 3.72 and 1.78 and display the answer in four decimal places.   8 Marks",
        questionNineteen = "c) Briefly describe the following arithmetic instructions:  6 Marks\n" +
                "i. SUBB\n" +
                "ii. IDV\n" +
                "iii. IMUL",


        questionTwenty = "QUESTION FOUR [20 MARKS]",
        questionTwentyOne = "a) Write an assembly language program to add FFFFh and 0001h and store the sum in an accumulator.  8 Marks",
        questionTwentyTwo = "b) Describe any three types of jumps in assembly programming.    3 Marks",
        questionTwentyThree = "c) Write code snippets in assembly language for each of the following cases.    9 Marks\n" +
                "i. Compare unsigned EAX to EBX, and copy the larger of the two into a variable named\n" +
                "Large\n" +
                "ii. Jump to label L1 if the memory word pointed to by ESI equals Zero\n" +
                "iii. Jump to label L2 if the double word in memory pointed to by EDI is even",


        questionTwentyFour = "QUESTION FIVE [20 MARKS]",
        questionTwentyFive = "a) State and explain the bitwise operator suitable for turning off a particular bit in a number 2 Marks",
        questionTwentySix = "b) Write an assembly language program to find the smallest number in an array 6 Marks",
        questionTwentySeven = "c) Write a procedure named multiply that computes the product of two signed 32-bit operands. The operands will be passed in registers ESI and EDI. The procedure should return the result on EAX. 6 Marks",
        questionTwentyEight = "d) Write Assembly Language code to evaluate expression: ((a+b)-(c+d))-e. Assume a,b,c,d and e are integer variables. Hint: Use procedure. 6 Marks ",
        questionTwentyNine = "",
        questionTwentyThirty = "",
    ),
    FullPaperData2019(
        unitName = "Advanced Software Engineering",
        academicYear = "2018/2019",
        unitCode = "BSD 3206",
        monthYear = "AUGUST, 2019 ",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Develop an object model including a class hierarchy diagram and an aggregation diagram showing the principal components of a PC and its system software.\n" +
                "(20 Marks)",
        questionThree = "b) Discuss ambiguities or omissions in the following statement of requirements for part of a ticket\n" +
                "issuing system.\n" +
                "An automated ticket issuing system sells rail tickets. Users select their destinations, and input " +
                "a credit card and a PIN. The rail ticket is issued and their credit card account charged with its " +
                "cost. When the user presses the start button, a menu display of potential destinations is " +
                "activated along with a message to the user to select a destination. Once a destination has been " +
                "selected, users are requested to input their credit card. Its validity is checked and the user is " +
                "requested to input a PIN. When the credit transaction has been validated, the ticket is issued.\n" +
                "(10 Marks)",


        questionFour = "QUESTION TWO",
        questionFive = "a) What are the four important attributes which all software products should have? Suggest four\n" +
                "other attributes of software that you think are important for software engineering.\n" +
                " (10 Marks)",
        questionSix = "b) Using an example, explain the difficulties of describing what software reliability means.\n" +
                " (10 Marks)",


        questionSeven = "QUESTION THREE",
        questionEight = "a) What are the stages involved in the review of a software design? (10 Marks) ",
        questionNine = "b) Discuss advantages of Software configuration control support during software maintenance.\n" +
                " (10 Marks)",


        questionTen = "QUESTION FOUR",
        questionEleven = "a) Explain how both the waterfall model and prototyping model of the software process can be\n" +
                "accommodated in the spiral model.\n" +
                "(10 Marks)",
        questionTwelve = "b) Why are evolutionary models considered by many to be the best approach to software\n" +
                "development in a modern context?\n" +
                "(10 Marks)",


        questionThirteen = "QUESTION FIVE",
        questionFourteen = "a) Discuss the differences and similarities between software configuration management during\n" +
                "development and maintenance.\n" +
                "(10 Marks)",
        questionFifteen = "b) Objective of validation and verifications? And what are the kinds of testing which\n" +
                "meet the objectives of V & V?\n" +
                "(10 Marks)",
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
    ),
    FullPaperData2019(
        unitName = "Principles of Marketing",
        academicYear = "2018/2019",
        unitCode = "BUSS 205:",
        monthYear = "AUGUST, 2019",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Your recent search in the internet about a new OPPO brand of phone is an indication that " +
                "you have decided to buy this product for the first time. Explain the adaption process you " +
                "underwent to purchase this product as a first time user? (8 Marks)",
        questionThree = "b) Distinguish between consumer markets and business markets? (2 Marks)",
        questionFour = "c) Identify any four micro-marketing environments and how they affect a company’s  marketing activities? (6 Marks)",
        questionFive = "d) Describe any four functions of channel distribution members? (6 Marks)",
        questionSix = "e) Discuss the components of Marketing Information System that marketers use to upgrade their activities? (8 Marks)",


        questionSeven = "QUESTION TWO",
        questionEight = "a) The 21st century companies are in the race to increase their sales and profit margins by using various strategies. Briefly describe any four of the product mix, pricing situations commonly embraced to achieve the above mileage? (8 Marks)",
        questionNine = "b) As a marketing manager of XYZ Company, You are approached by the Board of " +
                "Directors to enlighten them about the benefits of branding to the consumers and the " +
                "sellers, how would you advise them on the above? (8 Marks)",
        questionTen = "c) Highlight any four basic reasons for product promotion? (4 Marks)",


        questionEleven = "QUESTION THREE",
        questionTwelve = "a) Citing specific examples on each, distinguish between consumer and industrial products?   4 Marks",
        questionThirteen = "b) Describe the major causes of consumer dissonance and the measures taken by the marketers to revert the situation? (6 Marks)",
        questionFourteen = "c) Using a suitable illustration, discus the effects of motivation on consumer behavior?\n" +
                "(10 Marks)",


        questionFifteen = "QUESTION FOUR",
        questionSixteen = "a) Explain any four factors that marketers use to determine the social class of their target customers? 6 Marks",
        questionSeventeen = "b) For marketing to be a continuous and successful activity, new products must be developed frequently to meet changing customer needs and lifestyles. Describe the new product development process. (14 Marks)",


        questionEighteen = "QUESTION FIVE",
        questionNineteen = "a) With a suitable illustration, explain the product life cycle and the marketing strategies employed at each stage to sustain the process. (20 Marks)",
        questionTwenty = "",
        questionTwentyOne = "",
        questionTwentyTwo = "",
        questionTwentyThree = "",
        questionTwentyFour = "",
        questionTwentyFive = "",
        questionTwentySix = "",
    ),
    FullPaperData2019(
        unitName = "Java",
        academicYear = "2018/2019",
        unitCode = "BIT2204A",
        monthYear = "AUGUST, 2019",

        questionOne = "QUESTION ONE",
        questionTwo = "(a) Briefly explain the meaning of the following terms and write Java code that demonstrates its\n" +
                "usage. (6 Marks)\n" +
                "(i) Variable\n" +
                "(ii) Concatenation of data items\n" +
                " (iii) Assignment of a value",
        questionThree = "(b) Write a Java class that calculate the sum and the product of two numbers. (4 Marks)",
        questionFour = "(c) A number is called prime number if it is divisible by either itself or 1. Write a program in Java to find out if a number is prime in Java? (input 7: output true , input 9 : output false) (3 Marks)",
        questionFive = "(d) Write a java program the implements the following flow chart (4 Marks)\n" +
                "START -> Input A,B,C,D,E -> Total = A + B + C + D + E -> Average = Total/5 -> Display Average  -> END",
        questionSix = "(e) Write a Java Program the prints the following output using a repetition structure (4 Marks)\n" +
                "*\n" +
                "***\n" +
                "*****\n" +
                "***\n" +
                "*",
        questionSeven = "(f) Write a java class that implements the following pseudocode (5 Marks)\n" +
                "1 Start\n" +
                "2. Read number N,\n" +
                "3. Set remainder as N modulus 2,\n" +
                "4. If remainder is equal to 0 then number N is even, else number N is odd\n" +
                "5. Print output.\n" +
                "6. Stop",
        questionEight = "(g) Write a java class that implements the following ATM pseudocode (4 Marks)\n" +
                "If option = deposit then\n" +
                "Output 'Enter amount to deposit'\n" +
                "Input amount\n" +
                "balance <- balance - amount\n" +
                "If option = withdraw then\n" +
                "Input 'Enter amount to withdraw'\n" +
                "Input amount\n" +
                "balance <- balance - amount\n" +
                "Output 'Balance is ' balance\n" +
                "Until option = quit\n" +
                "Stop",



        questionNine = "QUESTION TWO",
        questionTen = "(a). State and explain three repetition structures as used in java programming. Write a sample java code to illustrate each structure.  6 Marks ",
        questionEleven = "(b). Describe the characteristics of the following methods and write a sample java for each case (4 Marks)\n" +
                "i. Constructor\n" +
                "ii. Static method ",
        questionTwelve = "(c). Describe the difference between getter method and a setter method. Write a sample code for each case (4 Marks).",
        questionThirteen = "(d). Write a Java class that calculate the area and perimeter of a rectangle. The class should contain at least two methods (6 Marks)",


        questionFourteen = "QUESTION THREE",
        questionFifteen = "(e) Write a java class that prompt the user to enter name, age, course name and outputs the information entered (4 Marks)",
        questionSixteen = "(b) An exercise book costs Kshs 20 and it is been sold at a discount of 12%. Write a java class that calculates discount price of the pen and print the cost of buying two exercise books. (5 Marks)",
        questionSeventeen = "(c) Briefly describe the meaning of the following concepts as used in Java programming. Write a\n" +
                "sample code to demonstrate each concept\n" +
                " (i) Implementing an interface (2 Marks)\n" +
                " (ii) Class inheritance (2 Marks)",
        questionEighteen = "(d) Describe the difference between object and a class. Write a sample java code to illustrate implementation of each concept (4 Marks)",
        questionNineteen = "(e) Describe three features of Java programming language (3 Marks)",


        questionTwenty = "QUESTION FOUR",
        questionTwentyOne = "(a) Write a Java class that calculate the area and circumference of a circle. The class should have at least two methods (6 Marks)",
        questionTwentyTwo = "(b) Peter Otieno is an employee in XYZ Company. He works 40hrs per week and the hourly pay rate is kshs 1000. Given that tax withholding rate is 9%, write a java class that calculate net pay for peter per week. The output should be formatted as follows: (6 Marks)\n" +
                "Employees Full Name:\n" +
                "Numbers of Hours worked in a week:\n" +
                "Hourly Pay Rate:\n" +
                "Gross Pay\n" +
                "Tax withholding rate:\n" +
                "Net Pay: ",
        questionTwentyThree = "(c) Write a java program called CheckPassFail which prints “PASS“ if the int variable ”mark” is more than or equal to 50; or prints “FAIL“ otherwise. The program shall always print “DONE” before exiting. (4 Marks)",
        questionTwentyFour = "(d) Describe the purposes of the following qualifiers as used in Java programming\n" +
                " (4 Marks)\n" +
                " (i) Public\n" +
                " (ii) Private\n" +
                " (iii) Protected\n" +
                " (v) Static",



        questionTwentyFive = "QUESTION FIVE ",
        questionTwentySix = "(a) Write a program called CheckOddEven which prints \"Odd Number\" if the int variable “number” is odd, or “Even Number” otherwise. The program shall always print “bye!” before exiting.",
        questionTwentySeven = "(b) Write a program called PrintDayInWord which prints “Sunday”, “Monday”, ... “Saturday” if the int variable \"dayNumber\" is 0, 1, ..., 6, respectively. Otherwise, it shall print \"Not a valid day\". (5 Marks)",
        questionTwentyEight = "(c)Write a program called SumAverageRunningInt to produce the sum of 1, 2, 3, ..., to 100. Store 1 and 100 in variables lowerbound and upperbound, so that we can change their values easily. Also compute and display the average. (5 Marks)\n" +
                "The output shall look like:\n" +
                "The sum of 1 to 100 is 5050\n" +
                "The average is 50.5",
        questionTwentyNine = "(d) Give two numbers a=25 and b=39, Write a Java program to compare two numbers and print results (4 Marks)",
        questionTwentyThirty = "(e) Describe the difference between static and non-static methods as used in java programming (2 Marks)",
    ),
    FullPaperData2019(
        unitName = "Information Systems Security Policies",
        academicYear = "2018/2019",
        unitCode = "BAC3216",
        monthYear = "AUGUST 2019",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Discuss the main elements making up information system. [6 Marks]",
        questionThree = "b) Expound on the major protocols used to secure communication. [6 Marks] ",
        questionFour = "c) What are residual risks? [2 Marks]",
        questionFive = "d) How are risk mitigation strategies implemented options? [4 Marks]",
        questionSix = "e) Explain the fundamental aspect of documenting risks via the process of risk assessment. [6 Marks]",
        questionSeven = "f) Discus how organizations institutionalize its policies, standards and practiced using education, training and awareness programs. [6 Marks]",



        questionEight = "QUESTION TWO",
        questionNine = "a) Why is it important for organizations to align to the defined policies and ISO standards? [6 Marks]",
        questionTen = "b) What are different types of firewall systems. [4 Marks]",
        questionEleven = "c) Discuss the tools used to implement a security policy [6 Marks]",
        questionTwelve = "d) Explain the concept of digital signature indicating its importance in security. [4 Marks]",


        questionThirteen = "QUESTION THREE",
        questionFourteen = "a) Identify two strategies used to control risks. [2 Marks]",
        questionFifteen = "b) Differentiate between vulnerabilities and threats. [2 Marks]",
        questionSixteen = "c) Examine the phases of security SDLC. [8 Marks]",
        questionSeventeen = "d) Discuss the various types of threats to information systems. [8 Marks]",


        questionEighteen = "QUESTION FOUR",
        questionNineteen = "a) What is Cipher text? [2 Marks]",
        questionTwenty = "b) What are the approaches of implementing firewall? [5 Marks]",
        questionTwentyOne = "c) What are the deliverables of risk assessment process? [4 Marks]",
        questionTwentyTwo = "d) Discuss the legal and ethical issues associated with the information security. [6 Marks]",
        questionTwentyThree = "e) How do organizations determine if they are operating up to the required internal and international standards? [3 Marks]",


        questionTwentyFour = "QUESTION FIVE",
        questionTwentyFive = "a) Discuss the strategies used to control risks. [8 Marks]",
        questionTwentySix = "b) Discuss the various types of security policies implemented in an organisation. [8 Marks]",
        questionTwentySeven = "c) Briefly discuss the ISO standards that relate to information security policies [4 Marks]",
    ),
    FullPaperData2019(
        unitName = "Data Structures And Algorithms",
        academicYear = "2019",
        unitCode = "BBIT 106/BIT 3101A:",
        monthYear = "AUGUST, 2019 ",

        questionOne = "QUESTION ONE",
        questionTwo = "a) List at least two differences between linear and nonlinear data structure [4 Marks]",
        questionThree = "b) Discuss the following cases used in estimating the complexity of an algorithm.[4 Marks]\n" +
                "i. Best case\n" +
                "ii. Worst case",
        questionFour = "c) Express the following functions in terms of Big-O notation   [2 Marks]\n" +
                "i. f(n) = an2 + bn + c\n" +
                "ii. f(n) = 2n + n log n + c",
        questionFive = "d) Explain three reasons why even a presumably good algorithm must be analyzed. [3 Marks]",
        questionSix = "e) Suggest and explain a suitable algorithm in each of the following fields: [4 Marks]\n" +
                "i. Mining in databases\n" +
                "ii. Determine the path with minimum distance from start node is S and final state is T\n" +
                "where S and T are nodes in a search space.",
        questionSeven = "f) Given a one dimensional array below, explain how you can locate an integer 2, using binary\n" +
                "search algorithm.\n" +
                "| 1 | 2 | 3 | 5 | 9 | 11 | 15 |",
        questionEight = "g) Suppose you are given an infix expression and asked to convert it into postfix. Explain the general procedure of achieving this. [8 Marks]",


        questionNine = "QUESTION TWO [20 MARKS]",
        questionTen = "a) You are given a one dimensional array below:\n" +
                "| 6 | 5 | 7 | 8 | 4 | 5 | 6 | 9 | 10 |\n" +
                "i. Remove the elements from this array and store them in a binary search tree. [3 Marks]\n" +
                "ii. Traverse the tree in (i) using post order traversal [3 Marks]\n" +
                "iii. Discuss any three operations you can perform on binary search tree apart from traversal.",
        questionEleven = "QUESTION THREE [20 MARKS]",
        questionTwelve = "a) Differentiate between a post condition and precondition in an algorithm. [2 Marks]",
        questionThirteen = "b) Explain any two advantages and disadvantages of selection sort [4 Marks]",
        questionFourteen = "c) Consider the following array of integers: 5, 1, 12, -5, 16, 2, 12, 14. Show the steps to sort the numbers in ascending order using a selection sort. [4 Marks]",
        questionFifteen = "d) Differentiate between a stack and a queue data structure  [2 Marks]",
        questionSixteen = "e) Define the priority queue abstract data type and give two operations associated with priority queue. [4 Marks]",
        questionSeventeen = "f) Consider the following queue, where queue is a circular queue having 6 memory cells, Front=2, Rear=4\n" +
                "Queue: _, A, C, D, _, _\n" +
                "Show the queue as following operations take place:\n" +
                "i) F is added to the queue\n" +
                "ii) Two letters are deleted\n" +
                "iii) R is added to the queue\n" +
                "iv) S is added to the queue  [4 Marks]",


        questionEighteen = "QUESTION FOUR [20 MARKS]",
        questionNineteen = "a) Differentiate between linear probing and chaining as collision solving techniques in a hash table. [4 Marks]",
        questionTwenty = "b) Design an algorithm that uses arrays to prompt the user to enter twenty six integer values then displays only those integers that are odd. [6 Marks]",
        questionTwentyOne = "c) You are given the following linked list\n" +
                "40 --> 52 --> 40 --> 30 --> 80 --> 70 --> 30\n" +
                "i. Explain the procedure of deleting the node that stores 80 in this list.\n" +
                "[4 Marks]\n" +
                "ii. Explain two drawbacks of using linked lists\n" +
                "[2 Marks]\n" +
                "iii. State and explain how this list can be implemented.\n" +
                "[4 Marks]",


        questionTwentyTwo = "QUESTION FIVE [20 MARKS]",
        questionTwentyThree = "a) Write a recursive algorithm in pseudo code to calculate the nth Fibonacci number.[5 Marks]",
        questionTwentyFour = "b) Discuss how genetic algorithms work. Give one example of a genetic algorithm. [5 Marks]",
        questionTwentyFive = "Given a binary tree, explain the process of convert the binary tree into max heap using illustrations [6 Marks]",
        questionTwentySix = "Explain the General Properties of Spanning Tree [4 Marks]",
    ),
    FullPaperData2019(
        unitName = "Internet Application Programming",
        academicYear = "2018/2019",
        unitCode = "BBIT 201",
        monthYear = "AUGUST 2019",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Differentiate between Web engineering and software engineering (6 Marks)",
        questionThree = "b) Describe the use the statement for..each loop in PHP ? (4 Marks)",
        questionFour = "c) Write is the correct syntax for creating a function that can be used to calculate the area of a circle in PHP. (4Marks)",
        questionFive = "d) Describe the use of frames in web design (4Marks)",
        questionSix = "e) Describe the following HTML tags\n" +
                "(i) <frame> (2Marks)\n" +
                "(ii) <CITE> (2Marks)\n" +
                "(iii) <BLOCKQUOTE> (2Marks)\n" +
                "(iv) <CELLPADDING> (2Marks)\n" +
                "(v) <BR> (2Marks)\n" +
                "(vi) <STRIKE> (2Marks)",


        questionSeven = "QUESTION TWO",
        questionEight = "a) Describe style rules as used in web development today (4Marks)",
        questionNine = "b) Describe the different ways of adding Styles to a html page (9Marks)",
        questionTen = "c) Describe ID and class as used in web development (4Marks)",
        questionEleven = "d) Which is the correct place to insert a JavaScript statements in a HTML document (3 marks)",


        questionTwelve = "QUESTION THREE",
        questionThirteen = "A training session is to be designed on how the company’s computers are linked together over the\n" +
                "internet. Your task is to produce self-explanatory notes for the trainees\n" +
                "Using examples produce a set of notes explaining each of the following computing terms:-\n" +
                "(i) Client (5Marks)\n" +
                "(ii) TCP/IP (5Marks)\n" +
                "(iii) Web Browser (5Marks)\n" +
                " (iv) Get/Post (5Marks)",


        questionFourteen = "QUESTION FOUR",
        questionFifteen = "Technology does not stand still and programmers have to continually update their skills\n" +
                "a) As a trainer explain the following terms. (5Marks)\n" +
                "(i) Tags\n" +
                "(ii) Head\n" +
                "(iii) Body\n" +
                "(iv) Titles\n" +
                "(v) Footers",
        questionSixteen = "b) Produce a basic set of HTML coding incorporating the terms in part a) (5Marks)",
        questionSeventeen = "c) Briefly explain the contrasts between the coding used in HTML with the coding used in lower level languages such as machine code. (5Marks)",
        questionEighteen = "d) Describe the characteristics of PHP-MySQL, that make it frequently used in Creating web pages. (5Marks)",

        questionNineteen = "QUESTION FIVE",
        questionTwenty = "a). Describe the purpose of the following as used in forms (9Marks)\n" +
                "(i) Radio Buttons\n" +
                "(ii) Check Boxes\n" +
                "(iii) Drop Down Boxes",
        questionTwentyOne = "b) Discuss the use of DBMS to design websites today. (5Marks)",
        questionTwentyTwo = "c) Explain how you get information from a form that is submitted using the \"get\" method? (6 Marks)",
        questionTwentyThree = "",
        questionTwentyFour = "",
        questionTwentyFive = "",
        questionTwentySix = "",
    ),
    FullPaperData2019(
        unitName = "Object Oriented Programming",
        academicYear = "2018/2019",
        unitCode = "BBIT 203/BIT 2108",
        monthYear = "AUGUST, 2019",

        questionOne = "QUESTION ONE",
        questionTwo = "a) Explain the concept of object technology as used in application development.  4 Marks",
        questionThree = "b) Explain at least five features in any object oriented programming language that support object technology 5 Marks ",
        questionFour = "c) With help of a sample program describe the structure of C++ program. 8 Marks",
        questionFive = "e) Differentiate between structure and class as used in C++. Give examples to support your argument. 4 Marks",
        questionSix = "f) With appropriate example describe what is function overloading. 5 Marks ",
        questionSeven = "QUESTION TWO [20 Marks] ",
        questionEight = "a) Debug the following program.\n" +
                "   #include<ionstream.r>\n" +
                "   main ( )\n" +
                "   {\n" +
                "       cout<<”enter two numbers:”; //prompt\n" +
                "       cin>> number1; //Read number\n" +
                "       float number 1, number 2,sum, average;\n" +
                "       cin>>number 2; //from keyboard\n" +
                "       average=sum/2;\n" +
                "       sum=number 1+number 2;\n" +
                "       void;\n" +
                "       cout<<”sum=”<<sum<<”\\n”;\n" +
                "       cout<<”average=”<<average<<”\\n”;\n" +
                "   }\n" +
                "}\n" +
                "6 Marks ",
        questionNine = "b) Find the errors in the following function prototype.\n" +
                "i). float average(a,b);\n" +
                "ii). int mul(int a,b);\n" +
                "iii). int display();\n" +
                "iv). void vect(int&v,int&size);\n" +
                "v). void print(float data[],size=20);\n" +
                "5 Marks ",
        questionTen = "c) State with a reason whether the following statements are true or false.\n" +
                "i). Function argument is a value returned by the function to the calling\n" +
                "program.\n" +
                "ii). When a function returns a value, the entire function can be assigned to\n" +
                "variable.\n" +
                "iii). When argument is passed by value the function works with the original\n" +
                "arguments in the calling program.\n" +
                "iv). A function can return a value by reference.\n" +
                "v). When argument is passed by reference, a temporary variable is created in the\n" +
                "calling program to hold the argument value.\n" +
                "5 Marks ",
        questionEleven = "d) Explain the following terms as used in object technology\n" +
                "i). Message passing\n" +
                "ii). Methods\n" +
                "iii). Object\n" +
                "iv). Polymorphism\n" +
                " 4 Marks ",
        questionTwelve = "QUESTION THREE [20 MARKS] ",
        questionThirteen = "a) What is operator overloading and why do we use this concept. Give the general syntax that is used to implement operator overloading. 4 Marks",
        questionFourteen = "b) Create a class named Shirt with data fields for collar size and sleeve length. Include a constructor that takes arguments for each field. Also include a String class variable named material and initialize it to “cotton”. Write a program " +
                "TestShirt to instantiate 3 Shirt objects with different collar sizes and sleeve lengths, and then display all the data, including material, for each shirt.  10 Marks ",
        questionFifteen = "c) Explain using an example how classes help to achieve program modularization. 6 Marks ",


        questionSixteen = "QUESTION FOUR [20 MARKS] ",
        questionSeventeen = "a) Write methods for bank operations such as recording customer’s details, recording\n" +
                "deposits and withdrawals. (Methods are declared within a class, main() is outside\n" +
                "the class)\n" +
                "Program should have the following:\n" +
                "Methods\n" +
                "\uF0B7 Get details\n" +
                "\uF0B7 Make deposit\n" +
                "\uF0B7 Make withdrawals\n" +
                "\uF0B7 Enquiry(optional)\n" +
                "\uF0B7 Main()     10 Marks ",
        questionEighteen = "b) Explain how you could modify the above program to achieve data hiding. 5 Marks ",
        questionNineteen = "c) Differentiate between intrinsic and user defined data type as used in C++. Give two examples in each case. 5 Marks ",

        questionTwenty = "QUESTION FIVE [20 MARKS] ",
        questionTwentyOne = "a) Write a program to capture student’s details. In your program include the following.\n" +
                "i. A constructor function\n" +
                "ii. A destructor and\n" +
                "iii. Other member function you may find necessary  10 Marks",
        questionTwentyTwo = "b) Discuss the following types functions as used in C++\n" +
                "(i) Inline function\n" +
                "(ii) Friend function\n" +
                "(iii)Constructor function\n" +
                "(iv) Virtual function\n" +
                "(v) Recursive function   10 Marks",
        questionTwentyThree = "",
        questionTwentyFour = "",
        questionTwentyFive = "",
        questionTwentySix = "",
    ),
    FullPaperData2019(
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
)


@Preview
@Composable
fun ExamPaperView2019() {
    val viewModel = viewModel<Exams2019SepDecViewModel>()
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
                                append("2019")
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
        /*
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
         */
        items(fullPaperData2019) { fullPaperData ->
            PaperExpanded2019(fullPaperData = fullPaperData,
                navHostController = rememberNavController())
        }
    }
}


@Composable
fun PaperExpanded2019(
    fullPaperData: FullPaperData2019,
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


