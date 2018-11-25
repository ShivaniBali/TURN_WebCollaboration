/**
 * generated by Xtext 2.15.0-SNAPSHOT
 */
package org.xtext.example.mydsl.tURN;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.tURN.Path#getStartPoint <em>Start Point</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.tURN.Path#getPathBody <em>Path Body</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.tURN.TURNPackage#getPath()
 * @model
 * @generated
 */
public interface Path extends EObject
{
  /**
   * Returns the value of the '<em><b>Start Point</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Point</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Point</em>' containment reference.
   * @see #setStartPoint(StartPoint)
   * @see org.xtext.example.mydsl.tURN.TURNPackage#getPath_StartPoint()
   * @model containment="true"
   * @generated
   */
  StartPoint getStartPoint();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.tURN.Path#getStartPoint <em>Start Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Point</em>' containment reference.
   * @see #getStartPoint()
   * @generated
   */
  void setStartPoint(StartPoint value);

  /**
   * Returns the value of the '<em><b>Path Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path Body</em>' containment reference.
   * @see #setPathBody(PathBody)
   * @see org.xtext.example.mydsl.tURN.TURNPackage#getPath_PathBody()
   * @model containment="true"
   * @generated
   */
  PathBody getPathBody();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.tURN.Path#getPathBody <em>Path Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path Body</em>' containment reference.
   * @see #getPathBody()
   * @generated
   */
  void setPathBody(PathBody value);

} // Path
