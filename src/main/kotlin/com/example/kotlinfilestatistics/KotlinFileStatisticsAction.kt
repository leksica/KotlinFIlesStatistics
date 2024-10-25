package com.example.kotlinfilestatistics

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ui.Messages
import org.jetbrains.kotlin.psi.KtNamedFunction
import com.intellij.psi.util.PsiTreeUtil

class KotlinFileStatisticsAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val project = event.project ?: return
        val editor = event.getData(CommonDataKeys.EDITOR) ?: return
        val psiFile = event.getData(CommonDataKeys.PSI_FILE) ?: return
        val document = editor.document

        // Check if the current file is a Kotlin file
        if (psiFile.fileType.name != "Kotlin") {
            Messages.showMessageDialog(
                project,
                "The current file is not a Kotlin file.",
                "Error",
                Messages.getErrorIcon()
            )
            return
        }

        // Total lines
        val totalLines = document.lineCount

        // Count TODO statements
        val text = document.text
        val todoRegex = Regex("""TODO\s*\((.*?)\)""")
        val todoMatches = todoRegex.findAll(text)
        val todoCount = todoMatches.count()

        // Find the longest function
        val functions = PsiTreeUtil.collectElementsOfType(psiFile, KtNamedFunction::class.java)
        var longestFunction: KtNamedFunction? = null
        var maxLines = 0

        for (function in functions) {
            val startLine = document.getLineNumber(function.textRange.startOffset)
            val endLine = document.getLineNumber(function.textRange.endOffset)
            val functionLines = endLine - startLine + 1

            if (functionLines > maxLines) {
                maxLines = functionLines
                longestFunction = function
            }
        }

        // Prepare results
        val results = StringBuilder()
        results.append("Total number of lines: $totalLines\n")
        results.append("Number of TODOs: $todoCount\n")

        if (longestFunction != null) {
            results.append("Longest function: ${longestFunction.name}\n")
            results.append("Lines in longest function: $maxLines")
        } else {
            results.append("No functions found in the file.")
        }

        // Display the results in a dialog
        Messages.showMessageDialog(
            project,
            results.toString(),
            "Kotlin File Statistics",
            Messages.getInformationIcon()
        )
    }
}