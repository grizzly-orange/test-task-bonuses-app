# test-task-bonuses-app
The app displays information about user bonuses.

![small](https://user-images.githubusercontent.com/326673/144238275-355026d8-8e69-4ac2-a64a-14fd82586a89.png)

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
Also App module sets user identity (clientId, deviceId) to BonusesView and (as optional case) sets colors of elements and sizes of fonts.
BonusesView gets bonuses info via using BonusesData module.

![BonusesApp drawio(1)](https://user-images.githubusercontent.com/326673/144274778-cd4fbeeb-2b46-4c97-852e-8f29d4cdf15a.png)

## App uses
* Fragments, ViewModel, Live data (+ livedata builder, livedata transformations), Kotlin coroutines (Kotlin Flow), event bus approach (for single-time events like errors), databinding, binding adapters, RelativeLayout, string pluralization.
* Network: Retrofit (+ OkHttp), Gson converter
* DI: Hilt

## Screenshots
### Loading state
![loading](https://user-images.githubusercontent.com/326673/144236988-bfd93cb6-eb59-4474-8989-99029921a8ae.png)
### Error message
![Screenshot_1638362405](https://user-images.githubusercontent.com/326673/144236921-12fd77eb-d9cb-4d13-8263-ce42e8504a85.png)
### Success state
![norm](https://user-images.githubusercontent.com/326673/144238934-e64f7d22-dbdc-414f-a663-a1686fde9602.png)
### Reaction on user actions (click buttons)
![reaction](https://user-images.githubusercontent.com/326673/144240625-48aafa10-1b45-4dcf-83de-652e36bfd24b.png)
### Custom colors
![blue](https://user-images.githubusercontent.com/326673/144236930-5345294b-66c4-46d8-8f1b-be7b18c0e255.png)
