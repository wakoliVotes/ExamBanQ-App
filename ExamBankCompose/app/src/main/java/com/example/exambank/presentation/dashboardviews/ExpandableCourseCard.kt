package com.example.exambank.viewscreens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.exambank.datalayer.models.TrimesterOneData
import com.example.exambank.presentation.dashboardviews.TrimesterTemplate
import com.example.exambank.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun ExpandableCourseCard(
    titleFontSize: TextUnit = MaterialTheme.typography.h6.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    shape: Shape = Shapes.medium,
    padding: Dp = 12.dp,
) {
    var expandedState by remember { mutableStateOf(false) }
    var expandedStateTwo by remember {
        mutableStateOf(false)
    }
    var expandedStateThree by remember {
        mutableStateOf(false)
    }

    val rotationState by animateFloatAsState(
        targetValue =
        if (expandedState) 180f else 0f
    )
    val rotationStateTwo by animateFloatAsState(
        targetValue =
        if (expandedStateTwo) 180f else 0f
    )
    val rotationStateThree by animateFloatAsState(
        targetValue =
        if (expandedStateThree) 180f else 0f
    )

Column {
    // TRI-1
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = shape,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        )
        {
            Row(
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = "Trimester I Units",
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down-Arrow"
                    )
                }
            }
            if (expandedState) {
                LazyColumn {
                    items(TrimesterOneData.unitTriOneList.size) {
                        TrimesterTemplate(TrimesterOneData.unitTriOneList[it])
                    }
                }
            }
        }
    }
    // TRI-2
    Spacer(modifier = Modifier.height(10.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = shape,
        onClick = {
            expandedStateTwo = !expandedStateTwo
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        )
        {
            Row(
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = "Trimester II Units",
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationStateTwo),
                    onClick = {
                        expandedStateTwo = !expandedStateTwo
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down-Arrow"
                    )
                }
            }
            if (expandedStateTwo) {
                LazyColumn {
                    items(TrimesterOneData.unitTriOneList.size) {
                        TrimesterTemplate(TrimesterOneData.unitTriOneList[it])
                    }
                }
            }
        }
    }
    // TRI-3
    Spacer(modifier = Modifier.height(10.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = shape,
        onClick = {
            expandedStateThree = !expandedStateThree
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        )
        {
            Row(
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = "Trimester III Units",
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationStateThree),
                    onClick = {
                        expandedStateThree = !expandedStateThree
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down-Arrow"
                    )
                }
            }
            if (expandedStateThree) {
                LazyColumn {
                    items(TrimesterOneData.unitTriOneList.size) {
                        TrimesterTemplate(TrimesterOneData.unitTriOneList[it])
                    }
                }
            }
        }
    }
   }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun ExpandableCourseCardPreview() {
    ExpandableCourseCard()
}