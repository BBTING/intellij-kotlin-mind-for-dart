package com.oboenikui.idea_plugin.flutter_wrap_widget.postfix

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplatePsiInfo
import com.intellij.psi.PsiElement

object WrapPostfixTemplatePsiInfo : PostfixTemplatePsiInfo() {
    override fun createExpression(psiElement: PsiElement, s: String, s1: String): PsiElement {
        return psiElement
    }

    override fun getNegatedExpression(psiElement: PsiElement): PsiElement {
        return psiElement
    }
}