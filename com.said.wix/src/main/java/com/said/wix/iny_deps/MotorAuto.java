package com.said.wix.iny_deps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MotorAuto implements Motores {
	
	private static final Logger log = LoggerFactory.getLogger(MotorAuto.class);

	@Override
	public void enciendeMotor() {
		log.info("Encendiendo motor del automóvil!!");
	}

}