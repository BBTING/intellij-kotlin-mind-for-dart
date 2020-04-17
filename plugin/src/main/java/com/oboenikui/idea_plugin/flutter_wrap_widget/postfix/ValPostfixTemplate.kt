package com.oboenikui.idea_plugin.flutter_wrap_widget.postfix

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.jetbrains.lang.dart.ide.refactoring.introduce.DartIntroduceFinalVariableHandler

class ValPostfixTemplate(provider: PostfixTemplateProvider) : PostfixTemplate(ID, NAME, KEY, EXAMPLE, provider) {
    override fun isApplicable(context: PsiElement, copyDocument: Document, newOffset: Int): Boolean {
        return true
    }

    override fun expand(context: PsiElement, editor: Editor) {
        val start = editor.selectionModel.selectionStart
        editor.selectionModel.setSelection(start - 1, start)

        DartIntroduceFinalVariableHandler().invoke(context.project, editor, context.containingFile, null)
    }

    companion object {
        const val ID = "dart-postfix-val"
        const val NAME = ".val"
        const val KEY = ".val"
        const val EXAMPLE = "expr.val => final foo = expr;"
    }
}

