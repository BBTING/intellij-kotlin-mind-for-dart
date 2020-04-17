package com.oboenikui.idea_plugin.flutter_wrap_widget.postfix

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateExpressionSelector
import com.intellij.openapi.editor.Document
import com.intellij.psi.PsiElement
import com.intellij.psi.util.parentOfType
import com.intellij.util.Function
import com.jetbrains.lang.dart.psi.DartCallExpression
import com.jetbrains.lang.dart.psi.DartClass
import com.jetbrains.lang.dart.psi.DartReference

object WrapPostfixTemplateExpressionSelector : PostfixTemplateExpressionSelector {
    override fun hasExpression(context: PsiElement, document: Document, newOffset: Int): Boolean {
        val dartClass = resolveClass(context)
                ?: return false
        println(dartClass.name)
        return dartClass.isWidget
    }

    private fun resolveClass(context: PsiElement): DartClass? {
        val reference = context.parentOfType<DartReference>() ?: return null
        var lastElement: PsiElement? = reference
        while (lastElement != context) {
            if (lastElement == null) return null

            lastElement = lastElement.lastChild
        }
        return reference.resolveDartClass().dartClass ?: run {
            // [workaround] resolve constructor call
            ((reference as? DartCallExpression)?.expression as? DartReference)?.resolve()?.parentOfType<DartClass>()
        }
    }

    private val DartClass.isWidget: Boolean
        get() {
            return name == "Widget" || this.superClass?.resolveReference()?.parentOfType<DartClass>()?.isWidget ?: false
        }

    override fun getExpressions(context: PsiElement, document: Document, offset: Int): List<PsiElement> {
        return listOf()
    }

    override fun getRenderer(): Function<PsiElement, String> {
        return Function {
            ""
        }
    }

}