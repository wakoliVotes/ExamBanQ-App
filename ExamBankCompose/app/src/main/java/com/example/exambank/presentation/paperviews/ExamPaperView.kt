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
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.exambank.R
import com.example.exambank.ui.theme.black
import com.example.exambank.ui.theme.white


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
    var questionTwentySeven: String,
    var questionTwentyEight: String,
)

val fullPaperData = listOf(
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
        questionTwentyTwo = "c) Explain what the following MS-DOS commands will do during file management: (5 Marks)\ni) dir /W\n ii) dir /p\n iii) diskcopy G: H:\n iv) dir /OD\n  v) chkdsk G: /F\n",
        questionTwentyThree = "d) Give FOUR reasons why Ubuntu is considered ‘safe’ and not prone to viruses. (4 Marks)\n\n e) Explain pros and cons of a command line interface. (4 Marks)",

        questionTwentyFour = "QUESTION FIVE [10 Marks]",
        questionTwentyFive = "a) List and describe the THREE memory allocation algorithms. (6 Marks)",
        questionTwentySix = "b) Assume you have the following jobs to execute with one processor, with the jobs arriving in the order listed here:\ni ===T(pi)\n0 == 80\n1 == 20\n2 == 10\n3 == 20\n4 == 50\n\ni) Suppose a system uses FCFS scheduling. Create a Gantt chart illustrating the execution of these processes. (2 Marks)\nii) Calculate the average wait time for the processes. (2 Marks)",
        questionTwentySeven = "c) What is a race condition? Give an example. (4 Marks) ",
        questionTwentyEight = "d) Discuss the advantages and disadvantages of user level threads. (6 Marks)",
    ),
    FullPaperData(
        unitName = "Java Programming",
        academicYear = "2022",
        unitCode = "BSC 301",
        monthYear = "MAY, 2023",

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
        unitName = "Operating Systems",
        academicYear = "2019",
        unitCode = "BSC 201",
        monthYear = "AUGUST, 2022",

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
    )
)


@Preview
@Composable
fun ExamPaperView() {
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
                        text = "Explore Papers",
                        modifier = Modifier
                            .padding(4.dp),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Monospace
                        )
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
                .fillMaxWidth()
                .height(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = fullPaperData.unitName,
                modifier = Modifier.padding(start = 8.dp),
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                )
            )
            IconButton(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .rotate(if (isExpanded) 180f else 0f),
                onClick = {
                    /*TODO*/
                    isExpanded = !isExpanded
                }) {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 4.dp)
                )
            }
        }
        if (isExpanded) {
            // start of column
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Header items card
                Card(

                    shape = RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp),
                    backgroundColor = Color.White,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .height(320.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = null,
                            modifier = Modifier
                                .clip(CircleShape)
                                .height(80.dp)
                                .width(80.dp)
                            ,
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
                                Spacer(modifier = Modifier.height(5.dp))
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
                                Spacer(modifier = Modifier.height(5.dp))
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
                                Spacer(modifier = Modifier.height(5.dp))
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
                                Spacer(modifier = Modifier.height(5.dp))
                                // 1st Divider
                                Box(

                                    modifier = Modifier
                                        .height(4.dp)
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
                                            fontSize = 14.sp,
                                            fontFamily = FontFamily.SansSerif,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    Text(

                                        text = "Answer Question One & ANY OTHER TWO",
                                        style = TextStyle(
                                            color = Color.Black,
                                            fontSize = 14.sp,
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
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = fullPaperData.questionTwentySeven,
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
                        text = fullPaperData.questionTwentyEight,
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
                        text = "---------END OF QUESTION PAPER---------------",
                        color = black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
            }
        }
    }
}


