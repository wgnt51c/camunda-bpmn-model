/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.bpm.model.bpmn.impl.instance.dc;

import org.camunda.bpm.model.bpmn.impl.instance.BpmnModelElementInstanceImpl;
import org.camunda.bpm.model.bpmn.instance.dc.Font;
import org.camunda.bpm.model.xml.ModelBuilder;
import org.camunda.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder;
import org.camunda.bpm.model.xml.type.attribute.Attribute;

import static org.camunda.bpm.model.bpmn.impl.BpmnModelConstants.*;
import static org.camunda.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The DC font element
 *
 * @author Sebastian Menski
 */
public class FontImpl extends BpmnModelElementInstanceImpl implements Font {

  private static Attribute<String> nameAttribute;
  private static Attribute<Double> sizeAttribute;
  private static Attribute<Boolean> isBoldAttribute;
  private static Attribute<Boolean> isItalicAttribute;
  private static Attribute<Boolean> isUnderlineAttribute;
  private static Attribute<Boolean> isStrikeTroughAttribute;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(Font.class, DC_ELEMENT_FONT)
      .namespaceUri(DC_NS)
      .instanceProvider(new ModelTypeInstanceProvider<Font>() {
        public Font newInstance(ModelTypeInstanceContext instanceContext) {
          return new FontImpl(instanceContext);
        }
      });

    nameAttribute = typeBuilder.stringAttribute(DC_ATTRIBUTE_NAME)
      .namespace(DC_NS)
      .build();

    sizeAttribute = typeBuilder.doubleAttribute(DC_ATTRIBUTE_SIZE)
      .namespace(DC_NS)
      .build();

    isBoldAttribute = typeBuilder.booleanAttribute(DC_ATTRIBUTE_IS_BOLD)
      .namespace(DC_NS)
      .build();

    isItalicAttribute = typeBuilder.booleanAttribute(DC_ATTRIBUTE_IS_ITALIC)
      .namespace(DC_NS)
      .build();

    isUnderlineAttribute = typeBuilder.booleanAttribute(DC_ATTRIBUTE_IS_UNDERLINE)
      .namespace(DC_NS)
      .build();

    isStrikeTroughAttribute = typeBuilder.booleanAttribute(DC_ATTRIBUTE_IS_STRIKE_THROUGH)
      .namespace(DC_NS)
      .build();

    typeBuilder.build();
  }

  public FontImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public String getName() {
    return nameAttribute.getValue(this);
  }

  public void setName(String name) {
    nameAttribute.setValue(this, name);
  }

  public Double getSize() {
    return sizeAttribute.getValue(this);
  }

  public void setSize(Double size) {
    sizeAttribute.setValue(this, size);
  }

  public Boolean isBold() {
    return isBoldAttribute.getValue(this);
  }

  public void setBold(boolean isBold) {
    isBoldAttribute.setValue(this, isBold);
  }

  public Boolean isItalic() {
    return isItalicAttribute.getValue(this);
  }

  public void setItalic(boolean isItalic) {
    isItalicAttribute.setValue(this, isItalic);
  }

  public Boolean isUnderline() {
    return isUnderlineAttribute.getValue(this);
  }

  public void SetUnderline(boolean isUnderline) {
    isUnderlineAttribute.setValue(this, isUnderline);
  }

  public Boolean isStrikeThrough() {
    return isStrikeTroughAttribute.getValue(this);
  }

  public void setStrikeTrough(boolean isStrikeTrough) {
    isStrikeTroughAttribute.setValue(this, isStrikeTrough);
  }
}