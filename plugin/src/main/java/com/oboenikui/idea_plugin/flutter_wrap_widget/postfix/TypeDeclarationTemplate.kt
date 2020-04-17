package com.oboenikui.idea_plugin.flutter_wrap_widget.postfix

import com.intellij.codeInsight.template.Template
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateExpressionSelector
import com.intellij.codeInsight.template.postfix.templates.StringBasedPostfixTemplate
import com.intellij.openapi.editor.Document
import com.intellij.psi.PsiElement
import com.intellij.util.Function

class TypeDeclarationTemplate(provider: DartPostfixTemplateProvider) : StringBasedPostfixTemplate(
        "type declaration",
        ":",
        "expr: -> type expr",
        TypeDeclarationTemplateExpressionSelector,
        provider
) {

    override fun getTemplateString(element: PsiElement): String? {
        return "\$type$ \$expr$\$END$"
    }

    override fun setVariables(template: Template, element: PsiElement) {
        template.addVariable("type", "ClassName", "ClassName", true)
    }
}

object TypeDeclarationTemplateExpressionSelector : PostfixTemplateExpressionSelector {
    override fun hasExpression(p0: PsiElement, p1: Document, p2: Int): Boolean {
        return true
    }

    override fun getRenderer(): Function<PsiElement, String> {
        return Function { it.text }
    }

    override fun getExpressions(p0: PsiElement, p1: Document, p2: Int): List<PsiElement> {
        println(p0.text)
        return listOf(p0)
    }
}