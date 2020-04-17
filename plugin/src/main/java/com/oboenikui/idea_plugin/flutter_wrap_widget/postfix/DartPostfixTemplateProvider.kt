package com.oboenikui.idea_plugin.flutter_wrap_widget.postfix

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

class DartPostfixTemplateProvider : PostfixTemplateProvider {
    override fun getTemplates(): Set<PostfixTemplate> {
        return setOf(WrapSingleTemplate,
                TypeDeclarationTemplate(this),
                ValPostfixTemplate(this),
                VarPostfixTemplate(this))
    }

    override fun isTerminalSymbol(currentChar: Char): Boolean {
        return currentChar == '.' || currentChar == ':'
    }

    override fun preExpand(psiFile: PsiFile, editor: Editor) {}
    override fun afterExpand(psiFile: PsiFile, editor: Editor) {}
    override fun preCheck(psiFile: PsiFile, editor: Editor, i: Int): PsiFile {
        return psiFile
    }
}