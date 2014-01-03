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
package org.camunda.bpm.model.bpmn;

/**
 * <p>A BPMN 2.0 Model</p>
 *
 * <p>Each {@link BpmnModel} has its own {@link BpmnElementFactory} which must
 * be used for creating instances of new {@link BpmnModelElement BpmnModelElements}:
 *
 * <pre>
 * BpmnModel model = Bpmn.createEmptyModel();
 * BpmnElementFactory factory = model.getBpmnElementFactory();
 *
 * Definitions definitions = factory.createDefinitions();
 * // set model properties on definitions ...
 *
 * model.setDefinitions(definitions);
 * </pre>
 *
 * </p>
 *
 * @author Daniel Meyer
 *
 */
public interface BpmnModel {

  /**
   * The factory to be used for creating new elements in this model. Only elements
   * obtained through this factory can be added as child elements to the model.
   *
   * @return the {@link BpmnElementFactory} for creating new elements in this model.
   */
  BpmnElementFactory getBpmnElementFactory();

  /**
   * @return the {@link Definitions}, root element of the Bpmn Model.
   * */
  Definitions getDefinitions();

  /**
   * Set the Bpmn Definitions Root element
   * @param definitions the {@link Definitions} element to set
   * */
  void setDefinitions(Definitions definitions);

  void printModel();
}
