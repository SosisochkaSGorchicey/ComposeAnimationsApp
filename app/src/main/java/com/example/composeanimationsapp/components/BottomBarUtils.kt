package com.example.composeanimationsapp.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.resources.R as CoreRes

enum class BottomBarItem {
    CatGallery,
    CartoonGallery,
    Other //todo change
}

@Composable
fun BottomBarItem.toIcon(): Painter = when (this) {
    BottomBarItem.CatGallery -> CoreRes.drawable.cat_icon
    BottomBarItem.CartoonGallery -> CoreRes.drawable.rick
    BottomBarItem.Other -> CoreRes.drawable.cat_icon
}.run { painterResource(id = this) }

@Composable
fun BottomBarItem.toTitle(): String = when (this) {
    BottomBarItem.CatGallery -> CoreRes.string.cat_gallery
    BottomBarItem.CartoonGallery -> CoreRes.string.rick_and_morty
    BottomBarItem.Other -> CoreRes.string.cat_gallery
}.run { stringResource(id = this) }