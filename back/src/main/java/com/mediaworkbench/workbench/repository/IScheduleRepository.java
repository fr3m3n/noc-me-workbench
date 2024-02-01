package com.mediaworkbench.workbench.repository;

import com.mediaworkbench.workbench.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Long> {
}
