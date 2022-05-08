# Design Document(V1.2)

**Author**: Team One

## 1 Design Considerations

### 1.1 Assumptions

Team One was hired by **FLooring Icon Inc.** to develop an Android application, to help alleviate some of their inventory issues. Flooring Icon Inc. has been having issues with logging and keeping an accurate detailed inventory for the stores they supply. In orde to accomplish this task, Team One will be utilzing Google's Android official integrated development environment **Android Studio**, which was designed specifically for Android application development.

The Android application will be referred from this point on as **Flooring Manager**, and will be supported by an older Android version API to ensure that the software can be compiled, executed on older Android systems. This was done with the **stores** in mind, as one of our priorities is to keep cost of overhead low. In addition to the creation of the _flooring manager_ application, Team One will implement a database system that will store a list of different floors that will be _queryable_ by a specific hierarchical structure. The database system will implement basic CRUD operations, that are only to be done by an _employee_ and not a basic _user_. This will require an authentication, registration process that Team One will implement with the use of a third party API called _Back4App_ that will serve as our backend and database. With this lightweight API we will be able to achieve all the necessary requirements that have been laid out by Flooring Icon Inc. The logic, and backend of our software will be scripted in the programming language Java.

### 1.2 Constraints

As mentioned in **Assumptions(1.1)** the _flooring manager_ application needs to utilize a database. Currently Team One is weighing out pros and cons of different database implementations. The _flooring manager_ Android application must be queryable and the query must return floors based on categories and types._Flooring manager_ should not require overly complex queries, but must implement basic CRUD operations. As our backend and database server are housed off the Android device, the only space requriements will be for said application itself. This was done with the user's Android device's memory in mind.

### 1.3 System Environment

Flooring Icon Incoporated requested for an Android application that can readily keep and update inventory across several stores in real time. Team One's _flooring manager_ application will be readily accessible on any Android device, but was primarily designed for Android mobile devices. The API _Back4App_ will ensure that our application is not only fluid, dynamic but portable and powerful. The Android application will be produced and programmed in Android Studio, utilizing Google's official Android Studio Development Kit. _Flooring manager_, will be deployed on the Android App Store, and is meant to be utilized on an Android mobile device.

The _flooring manager_ application will accept user input key strokes, that will permit communication with the software. Team One is still in process of implementing a database system and schema. Team One is unaware if there will be further interaction between software and hardware, as the database system is still relatively early in it's conception. Regardless, Team One belives that _Back4App_ will be a powerful addition to _flooring manger_, and we do not forsee any issues pertaining to complexity, design or dependencies.

## 2 Architectural Design

### 2.1 Component Diagram

![component-diagram(v1)](./component_diagram.png "Component Diagram(v1)")

Team One has incorporated five(5) components in our intial design. As said application is fairly straightforward:(1) A _User Interface_ component which represents the actual Android software application, (2) An _Authentication Management_ component which represents the two(2) distinct types of users and the different access/permissions, (3) An **Inventory Management** component which will provide the necessary hierachry and class structure to query our floor database as laid out in said requirements, (4) A **Store Management** component that will manage the list of stores, which will be made of stores that will have an editable inventory, and (5) A **Database System** that will house all the necessary information for our Android Application.

### 2.2 Deployment Diagram

![deployment-diagram(v1)](./deployment_diagram.png "Deployment Diagram(v1)")

Team One's initial deployment plan is shown above. The UI/UX portion of the diagram is represented by the Flooring Manager Android application. It is is connected to the functional components of our deployment diagram which are represented by the three(3) components: _Inventory Management System_, _Store Management System_, and an _Authentication System_. The functional components are connected to an external database system called _Back4App_ which will make up the core of our back-end and database integration.

## 3 Low-Level Design

### 3.1 Class Diagram

<img src="../Design-Team/teamdesign.png">

Team One's class diagram shown above, depicts all the classes and relationships amongs those classes in our _flooring manager_ application. The class diagram above displays the databse of floors that store the several different types of floors that all inherit from the class _floorType_. The _floorType_ class is meant to be an abstraction of the different _floor_ types.

The above class diagram also features the relationship and interaction between two distinct pair of classes. All employees are users, and all users(and employees) are able to interact with the _StoreList_ compoenent. While **only** the _Employee_ class will be able to interact with individual stores. The _Employee_ class will have the capability and necessary permissions to add,delete,and edit inventory in a specific _Store_. The _StoreList_ component is made of unique instances of _Store_.

### 3.2 Other Diagrams

![state-diagram(v1)](./state_diagram.png "State Diagram(v1)")

Team One has attached a relatively simple state diagram to ensure that the necessary software requirements were properly met. As showcased in the diagram above, there are two(2) states: A standard _user_ will have basic permissions to view all stores, display the inventory of said stores and able to _search_ for specific floors by category; The **employee** state will include all the basic permissions of the _user_ state but in addition be able to _add,edit,and delete_ items in the store they are employed by.

## 4 User Interface Design
![UI/UX(v1)](./UserInterfaceDesign.png "User Interface UI/UX Design(v1)")