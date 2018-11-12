package com.cg.mobilebilling.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mobilebilling.beans.Plan;

public interface PlanDAO extends JpaRepository<Plan, Integer> {

}
