package com.brasstacks.angular_dart_generator.action;

import javax.swing.*;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

public class GenerateComponentDialog extends DialogWrapper {

    private final Listener listener;
    private JTextField componentNameTextField;
    private JPanel contentPanel;

    public GenerateComponentDialog(final Listener listener) {
        super(null);
        this.listener = listener;
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return contentPanel;
    }

    @Override
    protected void doOKAction() {
        super.doOKAction();
        this.listener.onGenerateComponentClicked(componentNameTextField.getText());
    }

    @Nullable
    @Override
    public JComponent getPreferredFocusedComponent() {
        return componentNameTextField;
    }

    public interface Listener {
        void onGenerateComponentClicked(String componentName);
    }
}
