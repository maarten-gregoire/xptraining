package org.cegeka.vampireslayer;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class HunterTest {
	private Hunter hunter;

	@Before
	public void setup() {
		hunter = new Hunter();
	}

	@Test
	public void canHunt_givenDayTime_thenCannotHunt() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, Calendar.APRIL, 12, 16, 1);
		Date huntingTime = calendar.getTime();

		assertThat(hunter.canHunt(huntingTime)).isFalse();
	}

	@Test
	public void canHunt_givenNightTime_thenCanHunt() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, Calendar.APRIL, 12, 1, 1);
		Date huntingTime = calendar.getTime();

		assertThat(hunter.canHunt(huntingTime)).isTrue();
	}

	@Test
	public void canHunt_givenMidnight_thenCanHunt() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, Calendar.APRIL, 12, 0, 0);
		Date huntingTime = calendar.getTime();

		assertThat(hunter.canHunt(huntingTime)).isTrue();
	}

}
