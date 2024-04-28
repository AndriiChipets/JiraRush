package com.javarush.jira.bugtracking.task;

import com.javarush.jira.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static com.javarush.jira.bugtracking.task.TaskTestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Transactional
public class TaskServiceTest extends AbstractControllerTest {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskService taskService;

    static final String STATUS_ABSENT = "Task %s doesn't have %s status";
    static final String ACTIVITIES_ABSENT = "Task %s doesn't have any activities";

    @Test
    void calcWorkingTimeInMinuteWhenStatusesAreCorrect() {
        Task task = taskRepository.getExisted(ALL_STATUSES_TASK_ID);
        Long expectedWorkingTimeInMinutes = 180L;
        Long actualWorkingTimeInMinutes = taskService.calcWorkingTimeInMinute(task);
        assertEquals(expectedWorkingTimeInMinutes, actualWorkingTimeInMinutes);
    }

    @Test
    void calcTestingTimeInMinuteWhenStatusesAreCorrect() {
        Task task = taskRepository.getExisted(ALL_STATUSES_TASK_ID);
        Long expectedTestingTimeInMinutes = 150L;
        Long actualTestingTimeInMinutes = taskService.calcTestingTimeInMinute(task);
        assertEquals(expectedTestingTimeInMinutes, actualTestingTimeInMinutes);
    }

    @Test
    void calculateTestingTimeInMinuteWhenNoActivities() {
        Task task = taskRepository.getExisted(NO_ACTIVITIES_TASK_ID);

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> taskService.calcTestingTimeInMinute(task));
        assertEquals(String.format(ACTIVITIES_ABSENT, task.getTitle()), exception.getMessage());
    }

    @Test
    void calculateTestingTimeInMinuteWhenActivitiesIsNull() {
        Task task = taskRepository.getExisted(NO_ACTIVITIES_TASK_ID);
        task.setActivities(null);

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> taskService.calcTestingTimeInMinute(task));
        assertEquals(String.format(ACTIVITIES_ABSENT, task.getTitle()), exception.getMessage());
    }

    @Test
    void calculateTestingTimeInMinuteWhenNoDoneStatus() {
        Task task = taskRepository.getExisted(NO_DONE_STATUS_TASK_ID);

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> taskService.calcTestingTimeInMinute(task));
        assertEquals(String.format(STATUS_ABSENT, task.getTitle(), DONE), exception.getMessage());
    }

    @Test
    void calculateTestingTimeInMinuteWhenNoReadyForPreviewStatus() {
        Task task = taskRepository.getExisted(NO_READY_FOR_REVIEW_STATUS_TASK_ID);

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> taskService.calcTestingTimeInMinute(task));
        assertEquals(String.format(STATUS_ABSENT, task.getTitle(), READY_FOR_REVIEW), exception.getMessage());
    }
}
