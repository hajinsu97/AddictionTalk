package com.example.myapplication.model.user;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.example.myapplication.model.user.User;

/**
 * Unit tests for {@link User}
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UserUnitTest {

    @Test
    public void incrementCurrentStreakDays_adds1ToCurrentStreakDays() {
        User user = new User();
        assertThat(user.getCurrentStreakDays(), is(equalTo(0)));
        user.incrementCurrentStreakDays();
        assertThat(user.getCurrentStreakDays(), is(equalTo(1)));
        user.incrementCurrentStreakDays();
        assertThat(user.getCurrentStreakDays(), is(equalTo(2)));
    }

    @Test
    public void resetCurrentStreakDays_setsCurrentStreakDaysTo0() {
        User user = new User();
        assertThat(user.getCurrentStreakDays(), is(equalTo(0)));
        // Reset current streak days when it's already 0
        user.resetCurrentStreakDays();
        assertThat(user.getCurrentStreakDays(), is(equalTo(0)));
        // Reset current streak days when it's > 0
        user.incrementCurrentStreakDays();
        assertThat(user.getCurrentStreakDays(), is(equalTo(1)));
        user.resetCurrentStreakDays();
        assertThat(user.getCurrentStreakDays(), is(equalTo(0)));
    }


}