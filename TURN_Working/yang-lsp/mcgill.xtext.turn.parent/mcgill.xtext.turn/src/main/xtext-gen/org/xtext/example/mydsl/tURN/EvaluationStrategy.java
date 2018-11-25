/**
 * generated by Xtext 2.15.0-SNAPSHOT
 */
package org.xtext.example.mydsl.tURN;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Evaluation Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.tURN.EvaluationStrategy#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.tURN.EvaluationStrategy#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.tURN.EvaluationStrategy#getInfo <em>Info</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.tURN.EvaluationStrategy#getEvaluations <em>Evaluations</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.tURN.EvaluationStrategy#getIncludedStrategies <em>Included Strategies</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.tURN.TURNPackage#getEvaluationStrategy()
 * @model
 * @generated
 */
public interface EvaluationStrategy extends URNmodelElement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.example.mydsl.tURN.TURNPackage#getEvaluationStrategy_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.tURN.EvaluationStrategy#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Long Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Long Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Long Name</em>' containment reference.
   * @see #setLongName(LongName)
   * @see org.xtext.example.mydsl.tURN.TURNPackage#getEvaluationStrategy_LongName()
   * @model containment="true"
   * @generated
   */
  LongName getLongName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.tURN.EvaluationStrategy#getLongName <em>Long Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Long Name</em>' containment reference.
   * @see #getLongName()
   * @generated
   */
  void setLongName(LongName value);

  /**
   * Returns the value of the '<em><b>Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Info</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Info</em>' containment reference.
   * @see #setInfo(ConcreteStrategy)
   * @see org.xtext.example.mydsl.tURN.TURNPackage#getEvaluationStrategy_Info()
   * @model containment="true"
   * @generated
   */
  ConcreteStrategy getInfo();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.tURN.EvaluationStrategy#getInfo <em>Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Info</em>' containment reference.
   * @see #getInfo()
   * @generated
   */
  void setInfo(ConcreteStrategy value);

  /**
   * Returns the value of the '<em><b>Evaluations</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.tURN.Evaluation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Evaluations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Evaluations</em>' containment reference list.
   * @see org.xtext.example.mydsl.tURN.TURNPackage#getEvaluationStrategy_Evaluations()
   * @model containment="true"
   * @generated
   */
  EList<Evaluation> getEvaluations();

  /**
   * Returns the value of the '<em><b>Included Strategies</b></em>' reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.tURN.EvaluationStrategy}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Included Strategies</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Included Strategies</em>' reference list.
   * @see org.xtext.example.mydsl.tURN.TURNPackage#getEvaluationStrategy_IncludedStrategies()
   * @model
   * @generated
   */
  EList<EvaluationStrategy> getIncludedStrategies();

} // EvaluationStrategy
