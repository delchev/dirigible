package org.eclipse.dirigible.bpm.flowable;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.dirigible.bpm.flowable.dto.ExecutionData;
import org.eclipse.dirigible.commons.api.helpers.GsonHelper;
import org.eclipse.dirigible.commons.api.scripting.ScriptingException;
import org.eclipse.dirigible.engine.api.script.ScriptEngineExecutorsManager;
import org.eclipse.dirigible.engine.js.api.IJavascriptEngineExecutor;
import org.flowable.engine.delegate.BpmnError;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.engine.impl.el.FixedValue;
import org.springframework.beans.BeanUtils;

public class DirigibleCallDelegate implements JavaDelegate {
	
	private FixedValue handler;
	
	private FixedValue type;
	
	/**
	 * Getter for the handler attribute
	 * @return the handler
	 */
	public FixedValue getHandler() {
		return handler;
	}
	
	/**
	 * Setter of the handler attribute
	 * @param handler the handler
	 */
	public void setHandler(FixedValue handler) {
		this.handler = handler;
	}
	
	/**
	 * Getter for the engine attribute
	 * @return the engine
	 */
	public FixedValue getType() {
		return type;
	}
	
	/**
	 * Setter of the engine attribute
	 * @param handler the engine
	 */
	public void setType(FixedValue type) {
		this.type = type;
	}
	
	@Override
	public void execute(DelegateExecution execution) {
		
		try {
			Map<Object, Object> context = new HashMap<>();
			ExecutionData executionData = new ExecutionData();
			BeanUtils.copyProperties(execution, executionData);
			context.put("execution", GsonHelper.GSON.toJson(executionData));
			if (type == null) {
				type = new FixedValue(IJavascriptEngineExecutor.JAVASCRIPT_TYPE_DEFAULT);
			}
			ScriptEngineExecutorsManager.executeServiceModule(this.type.getExpressionText(), this.handler.getExpressionText(), context);
		} catch (ScriptingException e) {
			throw new BpmnError(e.getMessage());
		}		
	}

}
