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
package org.camunda.bpm.model.core.impl.type.child;

import org.camunda.bpm.model.core.instance.ModelElementInstance;
import org.camunda.bpm.model.core.type.ModelElementType;

/**
 * @author Daniel Meyer
 *
 */
public class ChildElementCollectionBuilderImpl<T extends ModelElementInstance> implements ChildElementCollectionBuilder<T> {

  protected final ModelElementType containingType;
  protected ChildElementCollection<T> collection;

  public ChildElementCollectionBuilderImpl(String localName, String namespaceUri, ModelElementType containingType) {
    this.containingType = containingType;
    collection = new NamedChildElementCollection<T>(localName, namespaceUri);
  }

  public ChildElementCollectionBuilderImpl(Class<T> type, ModelElementType containingType) {
    this.containingType = containingType;
    collection = new TypedChildElementCollection<T>(type);
  }

  public ChildElementCollectionBuilder<T> immutable() {
    collection.setMutable(false);
    return this;
  }

  public ChildElementCollection<T> build() {
    // TODO: register collection with containing type!
    return collection;
  }

}
