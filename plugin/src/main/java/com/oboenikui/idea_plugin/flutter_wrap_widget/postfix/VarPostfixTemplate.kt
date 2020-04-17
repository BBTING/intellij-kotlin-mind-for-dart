package com.oboenikui.idea_plugin.flutter_wrap_widget.postfix

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.jetbrains.lang.dart.ide.refactoring.introduce.DartIntroduceFinalVariableHandler
import com.jetbrains.lang.dart.ide.refactoring.introduce.DartServerExtractLocalVariableHandler

class VarPostfixTemplate(provider: PostfixTemplateProvider) : PostfixTemplate(ID, NAME, KEY, EXAMPLE, provider) {
    override fun isApplicable(context: PsiElement, copyDocument: Document, newOffset: Int): Boolean {
        return true
    }

    override fun expand(context: PsiElement, editor: Editor) {
        val start = editor.selectionModel.selectionStart
        editor.selectionModel.setSelection(start - 1, start)

        DartServerExtractLocalVariableHandler().invoke(context.project, editor, context.containingFile, null)
    }

    companion object {
        const val ID = "dart-postfix-var"
        const val NAME = ".var"
        const val KEY = ".var"
        const val EXAMPLE = "expr.var => var foo = expr;"
    }
}

