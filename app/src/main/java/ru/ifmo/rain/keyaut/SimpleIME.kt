package ru.ifmo.rain.keyaut

import android.inputmethodservice.InputMethodService
import android.view.KeyEvent
import android.view.View
import org.jetbrains.anko.*


class SimpleIME : InputMethodService() {
    override fun onCreateInputView(): View {
        return verticalLayout {
            button(theme = context.applicationInfo.theme) {
                setText(R.string.main_button)
                onClick {
                    currentInputConnection.commitText("Ты пидор", 0)
                }
            }.lparams(width = matchParent, height = dip(0), weight = 1.0f) {
                minimumHeight = dip(240)
            }

            linearLayout {
                button(theme = context.applicationInfo.theme) {
                    setText(R.string.text_clear)
                    onClick {
                        currentInputConnection.apply {
                            deleteSurroundingText(getTextBeforeCursor(100, 0).length, 0)
                        }
                    }
                }.lparams(width = dip(0), weight = 1.0f)

                button(theme = context.applicationInfo.theme) {
                    setText(R.string.send_text)
                    onClick {
                        currentInputConnection.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER))
                    }
                }.lparams(width = dip(0), weight = 1.0f)
            }.lparams(width = matchParent) {
                bottomMargin = dip(5)
                topMargin = dip(-5)
            }
        }
    }
}
