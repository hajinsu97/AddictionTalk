package com.addictiontalk.ui.logs;

import android.text.Editable;
import android.view.View;
import com.addictiontalk.R;
import com.addictiontalk.model.user.CravingLog;

/**
 * A TextWatcher implementation used to watch EditText components in {@link LogFragment} to populate
 * a {@link CravingLog}.
 */
public class CravingLogTextWatcher implements android.text.TextWatcher {

    private final CravingLog cravingLog;
    private final View view;

    public CravingLogTextWatcher(CravingLog cravingLog, View view) {
        this.cravingLog = cravingLog;
        this.view = view;
    }

    @Override
    public void afterTextChanged(Editable editable) {
        // TODO: Data Validation?
        String text = editable.toString();
        if (view.getId() == R.id.editTextDate) {
            cravingLog.setDate(text);
        } else if (view.getId() == R.id.editTextLocation) {
            cravingLog.setLocation(text);
        } else if (view.getId() == R.id.editTextCraving) {
            cravingLog.setCraving(text);
        } else if (view.getId() == R.id.editTextCost) {
            cravingLog.setCost(Double.valueOf(text));
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }
}
