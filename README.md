# ImageAppAssign
This Android app is designed to showcase a list of images on the screen. The app follows the MVVM architecture pattern and implements the API integration using Repositories and ViewModels.

Features:

Screen 1: View Images Button

The app's first screen features a button labeled "View Images."
Upon clicking this button, the user is taken to the second screen.
Screen 2: Image List

The second screen displays a list of images fetched from an API.
The list is implemented using a RecyclerView, providing an optimized and efficient scrolling experience.
Each item in the list represents an image.
Architecture:
The app follows the MVVM (Model-View-ViewModel) architecture pattern, which separates the concerns of data management and UI presentation. This helps in maintaining a clean and organized codebase.

API Integration:
The app integrates with a remote API to fetch the list of images. The API implementation is handled using Repositories and ViewModels. This ensures separation of concerns and provides a centralized and reusable approach for data handling and manipulation.

Technologies and Libraries:

Android Jetpack components: The app utilizes Android Jetpack components such as LiveData, ViewModel, and RecyclerView to enhance development productivity and maintainability.
Retrofit: The Retrofit library is used to make API requests and handle network communication.
Gson: Gson is used for JSON parsing, converting the API response into a structured format that can be easily consumed by the app.
RecyclerView: The RecyclerView component is used to efficiently display the list of images, providing smooth scrolling and optimized memory usage.
MVVM Architecture: The app follows the MVVM architectural pattern, separating concerns and improving code maintainability and testability.
Note:
This app is created as part of an Android internship test, demonstrating proficiency in Android development concepts, architectural patterns, API integration, and UI implementation.
