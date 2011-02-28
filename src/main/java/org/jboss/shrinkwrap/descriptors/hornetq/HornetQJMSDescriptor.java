/*
 * JBoss, Home of Professional Open Source.
 * Copyright (c) 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.shrinkwrap.descriptors.hornetq;

import org.jboss.shrinkwrap.descriptor.api.Descriptor;
import org.jboss.shrinkwrap.descriptor.api.Node;
import org.jboss.shrinkwrap.descriptor.impl.base.NodeProviderImplBase;
import org.jboss.shrinkwrap.descriptor.impl.base.XMLExporter;
import org.jboss.shrinkwrap.descriptor.spi.DescriptorExporter;

/**
 * http://hornetq.sourceforge.net/docs/hornetq-2.1.2.Final/user-manual/en/html/configuration-index.html#d0e12990
 * 
 * @author <a href="mailto:cdewolf@redhat.com">Carlo de Wolf</a>
 */
public class HornetQJMSDescriptor extends NodeProviderImplBase implements Descriptor {
    private final Node model;

    public HornetQJMSDescriptor() {
        this(new Node("configuration")
                .attribute("xmlns", "urn:hornetq")
                .attribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance")
                .attribute("xsi:schemaLocation", "urn:hornetq ../schemas/hornetq-jms.xsd")
        );
    }

    protected HornetQJMSDescriptor(Node configuration) {
        this.model = configuration;
    }
    
    @Override
    protected DescriptorExporter getExporter() {
        return new XMLExporter();
    }

    @Override
    public Node getRootNode() {
        return model;
    }

    public QueueDef queue(String name) {
        Node queue = model.getOrCreate("queue").attribute("name", name);
        return new QueueDef(model, queue);
    }
}
