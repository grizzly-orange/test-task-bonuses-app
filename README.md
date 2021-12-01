# test-task-bonuses-app
The app displays information about user bonuses.
![Screenshot_1638359659](https://user-images.githubusercontent.com/326673/144230182-994dd4d9-6e13-4ae9-881a-61ff0f84ff8f.png)

## App features
* to get bonuses info from network
* to display loading status
* to display error message on error during getting data
* to display bonuses data
* to react on screen buttons (button Info, button Next)

## App modules
* App module
* BonusesView module (android lib) that displays bonuses data.
* BonusesData module (android lib) that load bonuses data from network.
App module uses BonusesFragment of BonusesView module.
Also App module setup user identity (clientId, deviceId) to BonusesView and (as optional case) colors of elements and sizes of fonts.
BonusesView get bonuses info via using BonusesData module.

![BonusesApp drawio](https://user-images.githubusercontent.com/326673/144233888-44be8b56-4854-4fb3-81f8-a9b585756443.png)

## App uses
* Fragments, ViewModel, Live data (+ livedata builder, livedata transformations), Kotlin coroutines (Kotlin Flow), databinding, binding adapters, RelativeLayout, string pluralization.
* Network: Retrofit (+ OkHttp), Gson converter
* DI: Hilt
