/*
 * pragmatickm-procedure-style - Default style for procedures nested within SemanticCMS pages and elements.
 * Copyright (C) 2016, 2017, 2020  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of pragmatickm-procedure-style.
 *
 * pragmatickm-procedure-style is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * pragmatickm-procedure-style is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with pragmatickm-procedure-style.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.pragmatickm.procedure.style;

import com.aoindustries.web.resources.registry.Style;
import com.aoindustries.web.resources.servlet.RegistryEE;
import com.pragmatickm.procedure.model.Procedure;
import com.semanticcms.core.servlet.SemanticCMS;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("Registers the styles for procedures in RegistryEE and SemanticCMS.")
public class ProcedureStyle implements ServletContextListener {

	public static final Style PRAGMATICKM_PROCEDURE = new Style("/pragmatickm-procedure-style/pragmatickm-procedure.css");

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();

		// Add our CSS file
		RegistryEE.get(servletContext).global.styles.add(PRAGMATICKM_PROCEDURE);

		SemanticCMS semanticCMS = SemanticCMS.getInstance(servletContext);
		// Add link CSS class
		semanticCMS.addLinkCssClass(Procedure.class, "pragmatickm-procedure-procedure-link");
		// Add list item CSS class
		semanticCMS.addListItemCssClass(Procedure.class, "pragmatickm-procedure-list-item");
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// Do nothing
	}
}
