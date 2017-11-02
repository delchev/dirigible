package org.eclipse.dirigible.runtime.security.service;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.dirigible.api.v3.security.UserFacade;
import org.eclipse.dirigible.commons.api.helpers.ContentTypeHelper;
import org.eclipse.dirigible.commons.api.service.AbstractRestService;
import org.eclipse.dirigible.commons.api.service.IRestService;
import org.eclipse.dirigible.core.security.api.AccessException;
import org.eclipse.dirigible.runtime.security.processor.SecurityProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

/**
 * Front facing REST service serving the raw repository content
 */
@Singleton
@Path("/core/security")
@Api(value = "Core - Security", authorizations = { @Authorization(value = "basicAuth", scopes = {}) })
@ApiResponses({ @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden") })
public class SecurityRestService extends AbstractRestService implements IRestService {

	private static final Logger logger = LoggerFactory.getLogger(SecurityRestService.class);

	@Inject
	private SecurityProcessor processor;

	@Context
	private HttpServletResponse response;

	@GET
	@Path("/access")
	public Response listAccess() throws AccessException {
		String user = UserFacade.getName();
		if (user == null) {
			sendErrorForbidden(response, NO_LOGGED_IN_USER);
			return Response.status(Status.FORBIDDEN).build();
		}

		return Response.ok().entity(processor.renderAccess()).type(ContentTypeHelper.APPLICATION_JSON).build();
	}

	@GET
	@Path("/roles")
	public Response listRoles() throws AccessException {
		String user = UserFacade.getName();
		if (user == null) {
			sendErrorForbidden(response, NO_LOGGED_IN_USER);
			return Response.status(Status.FORBIDDEN).build();
		}

		return Response.ok().entity(processor.renderRoles()).type(ContentTypeHelper.APPLICATION_JSON).build();
	}

	@Override
	public Class<? extends IRestService> getType() {
		return SecurityRestService.class;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}
}
