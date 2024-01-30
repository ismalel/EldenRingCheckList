package com.ismalel.eldenringchecklist.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateMap
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.trimble.training.data.model.Section



@Composable
fun ExpandableList(sections: List<Section >) {
    val isExpandedMap = remember { List(sections.size) { index: Int -> index to true }
        .toMutableStateMap() }
    LazyColumn(
        content = {
            sections.onEachIndexed { index, sectionData ->
                Section(
                    sectionData = sectionData,
                    isExpanded = isExpandedMap[index] ?: true,
                    onHeaderClick = {
                        isExpandedMap[index] = !(isExpandedMap[index] ?: true)
                    }
                )
            }
        }
    )
}

@Composable
fun SectionItem(text: String) {
    Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Start) {
        val checkedState = remember { mutableStateOf(false) }
        Checkbox(checked = checkedState.value, onCheckedChange = {checkedState.value = it }, )
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
        )
    }
}

@Composable
fun SectionHeader(text: String, isExpanded: Boolean, onHeaderClicked: () -> Unit) {
    Row(modifier = Modifier
        .clickable { onHeaderClicked() }
        .background(Color.LightGray)
        .padding(vertical = 8.dp, horizontal = 8.dp)) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.weight(1.0f)
        )
        Icon(
            imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp
            else Icons.Default.KeyboardArrowDown,
            contentDescription = null,
        )
    }

}

fun LazyListScope.Section(
    sectionData: Section,
    isExpanded: Boolean,
    onHeaderClick: () -> Unit
) {

    item {
        SectionHeader(
            text = sectionData.headerText,
            isExpanded = isExpanded,
            onHeaderClicked = onHeaderClick
        )

    }
    if(isExpanded) {
        items(sectionData.items) {
            SectionItem(text = it)
        }
    }
}



