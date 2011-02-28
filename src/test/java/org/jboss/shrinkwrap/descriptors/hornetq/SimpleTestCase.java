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

import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A simple use case, see http://community.jboss.org/message/589834
 * 
 * @author <a href="mailto:cdewolf@redhat.com">Carlo de Wolf</a>
 */
public class SimpleTestCase {
    @Test
    public void test1() {
        HornetQJMSDescriptor descriptor = Descriptors.create(HornetQJMSDescriptor.class)
                .queue("MyQueue")
                    .entry("foo/bar");
        
        String actual = descriptor.exportAsString();
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<configuration xmlns=\"urn:hornetq\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:hornetq ../schemas/hornetq-jms.xsd\">\n" +
                "  <queue name=\"MyQueue\">\n" +
                "    <entry>foo/bar</entry>\n" +
                "  </queue>\n" +
                "</configuration>\n";
        assertEquals(expected, actual);
    }
}
