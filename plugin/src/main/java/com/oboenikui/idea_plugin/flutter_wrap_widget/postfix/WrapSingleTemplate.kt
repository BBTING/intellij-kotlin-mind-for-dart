package com.oboenikui.idea_plugin.flutter_wrap_widget.postfix

import com.intellij.codeInsight.template.postfix.templates.SurroundPostfixTemplateBase
import com.intellij.lang.surroundWith.Surrounder
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.oboenikui.idea_plugin.flutter_wrap_widget.postfix.WrapPostfixTemplatePsiInfo

object WrapSingleTemplate : SurroundPostfixTemplateBase(
        "wrapWith",
        "SomeWidget(child: expr)",
        WrapPostfixTemplatePsiInfo,
        WrapPostfixTemplateExpressionSelector
) {
    override fun getSurrounder(): Surrounder {
        return object : Surrounder {
            override fun isApplicable(p0: Array<out PsiElement>): Boolean {
                TODO("Not yet implemented")
            }

            override fun surroundElements(p0: Project, p1: Editor, p2: Array<out PsiElement>): TextRange? {
                TODO("Not yet implemented")
            }

            override fun getTemplateDescription(): String {
                TODO("Not yet implemented")
            }
        }
    }
}