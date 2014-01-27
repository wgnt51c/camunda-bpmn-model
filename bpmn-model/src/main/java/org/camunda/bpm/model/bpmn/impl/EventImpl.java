/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.model.bpmn.impl;

import org.camunda.bpm.model.bpmn.Event;
import org.camunda.bpm.model.bpmn.impl.instance.FlowNodeImpl;
import org.camunda.bpm.model.bpmn.instance.FlowNode;
import org.camunda.bpm.model.bpmn.Property;
import org.camunda.bpm.model.xml.ModelBuilder;
import org.camunda.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.camunda.bpm.model.xml.type.child.ChildElementCollection;
import org.camunda.bpm.model.xml.type.ModelElementType;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder;
import org.camunda.bpm.model.xml.type.child.SequenceBuilder;

import java.util.Collection;

import static org.camunda.bpm.model.bpmn.impl.BpmnModelConstants.*;

/**
 * @author Sebastian Menski
 *
 */
public abstract class EventImpl extends FlowNodeImpl implements Event {

  private static ModelElementType MODEL_TYPE;

  private static ChildElementCollection<Property> propertiesColl;

  public static void registerType(ModelBuilder modelBuilder) {

    ModelElementTypeBuilder builder = modelBuilder.defineType(Event.class, BPMN_ELEMENT_EVENT)
      .namespaceUri(BPMN20_NS)
      .abstractType()
      .extendsType(FlowNode.class);

    SequenceBuilder sequence = builder.sequence();

    propertiesColl = sequence.elementCollection(Property.class)
      .build();

    MODEL_TYPE = builder.build();
  }

  public EventImpl(ModelTypeInstanceContext context) {
    super(context);
  }

  public Collection<Property> getProperties() {
    return propertiesColl.get(this);
  }

}
