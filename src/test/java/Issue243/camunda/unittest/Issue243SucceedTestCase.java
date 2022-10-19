/*
 * vim: tabstop=4 expandtab shiftwidth=4 softtabstop=4
 * -*- coding: utf-8 -*-
 */
package Issue243;

import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.ProcessEngine;

import org.camunda.bpm.engine.exception.NotFoundException;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.history.HistoricExternalTaskLog;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.complete;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.externalTask;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.withVariables;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.assertThat;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.complete;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.processInstanceQuery;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.runtimeService;

public class Issue243SucceedTestCase {
    @Rule
    @ClassRule
    public static ProcessEngineRule rule = TestCoverageProcessEngineRuleBuilder.create().build();

    @Test
    @Deployment(resources = {
        "Issue243/camunda/unittest/Issue243-succeed.bpmn"
        }
    )
    public void testSucceed() {
        ProcessInstance processInstance = runtimeService().startProcessInstanceByKey("Process_Issue243");

        assertThat(processInstance).isActive();
    }
}
