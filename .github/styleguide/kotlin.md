# Kotlin Style Guide

기본적인 스타일 가이드는 [Google Kotlin Style Guide](https://developer.android.com/kotlin/style-guide?hl=ko) 를 따릅니다.


## Parameter/Argument
### Parameter 순서
- Context류의 parameter를 가장 앞에 위치한다.
(Context, Activity, Fragment, View등)
- Callback류의 parameter를 가장 뒤에 위치한다.
(XXXListener, XXXCallback, XXXSubject등)
```kotlin
fun getData: Data(context: Context, hashId: Int)
fun loadData(context: Context hashId: Int, listener: MyListener)
```

### Key

| Prefix | 설명 |
| ------------- | ------------- |
| `EXTRA_` | Intent |
| `PREF_` | SharedPreferences |
| `ARGUMENT_` | Fragment Arguments |
| `QUERY_` | Deeplink query parameter key |
- Key-Value로 활용되는 컴포넌트들의 Key는  `const val` 로 정의한다.
- Key로 정의된 이름의 String값은 동일하게 맞춰준다.
- Deeplink에서 사용되는 Query Parameter의 경우 `aaa://bb?key1=value1&key2=value2`와 같은 방식으로 전달되기때문에 query key와 맞춰준다.
```java
const val EXTRA_HASH_ID: String = "EXTRA_HASH_ID"
const val EXTRA_TRADE: String = "EXTRA_TRADE";
const val QUERY_REFERRER: String = "referrer";
```

### Key with Activity/Fragment
#### Activity
- Activity Intent에 `EXTRA_`를 넣어주는 경우, 해당 Activity에 `getIntent()`를 구현하고 이를 사용한다.
```kotlin
class MyActivity(): AppCompatActivity() {
    companion object {
	    @JvmStatic
	    fun getIntent(context: Context, param1: Int, param2: Int) = Intent(context, MyActivity::class).apply {
			putExtra(EXTRA_PARAM_1, param1)
			putExtra(EXTRA_PARAM_1, param2)
		}
	}
}
```

#### Fragment
- Fragment에 `ARGUMENT_`를 넣어주는 경우, 해당 Fragment에 `newInstance()`를 구현하고 이를 사용한다.
- Fragment 생성자의 Parameter로 넘기지 않는다.
[Best Practice to Instantiate Fragments with Arguments in Android](https://gunhansancar.com/best-practice-to-instantiate-fragments-with-arguments-in-android/)

#### 기타
- `startActivity()` / `getIntent()` / `newInstance()`에서 쓰이는 Key는 항상 `const val`로 만든다.


## Line
- 1줄에 100자를 넘지 않도록 작성한다.
- 코드간의 간격은 2줄이상 간격이 발생하지 않도록 한다.(최대 1줄 줄바꿈)

### Class
- Parameter개수가 많아서 줄바꿈이 필요한 경우, **파라미터의 시작지점부터 줄바꿈한다**
```java
class InputSingleTextView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
): ConstraintLayout(context, attrs, defStyleAttr)
```

- 줄바꿈이 필요한 부분부터 줄바꿈 하지 않고 위의 예시처럼 1개 단위로 줄바꿈을 해준다.
- 이런 함수를 호출하는 코드에서도 같은 패턴으로 맞춰서 호출한다.
```java
val view = MyCustomView.getInstance(
   this,
   getString(R.string.xxx),
   getString(R.string.xxx),
);
```


### Operator
- 많은 operator의 연산으로 줄바꿈이 필요한 경우, **operator 전에 줄바꿈한다.**
```java
val longName = anotherVeryLongVariable + anEvenLongerOne - thisRidiculousLongOne
	+ theFinalOne;
```
- 연산자의 경우는 줄바꿈이 필요한 위치부터 줄바꿈한다.

### Method chain
- Builder/RxJava 등 여러 함수를 chaining으로 사용하면서 줄바꿈이 필요한 경우, **`.`전에 줄바꿈한다.**
```java
ImageLoader.load(user.getProfileUrl())
        .placeholder(R.drawable.img_user_placeholder)
        .fitCenter()
        .into(binding.ivUser);
```

## 새파일 생성시 주석
- 새로운 파일을 만들때 자동으로 만들어지는 주석은 만들지 않는다.
- 예)
```java
/**
 * Created by ted on 2018-07-12.
 */
```
- 수정방법: `Preferences` -> `Editor` -> `File and Code Templates` -> `includes`탭 -> `File Header` 내용 삭제


## Util/Helper/Manager
- 특정기능을 수행하거나 상태를 관리하거나 분리되어 동작을 수행하는 클래스에 대한 사용처별 이름을 정의한다.
### Util
- `public static void AAA`등으로 쓰이는 여러곳에서 사용되는 util성 기능을 보아둔 클래스
- `aa.bb.cc.util` 패키지에 모두 모아둔다.
- 예) `DateFormatUtil`, `PixelUtil`, `BitmapUtil`등
### Helper
- 특정 패키지나 기능에서 한정되어 사용되는 `public static void AAA` 클래스
- 공통으로 쓰이지 않고 특정 기능의 코드를 분리하기 위한 용도로 사용한다.
- 예) `NotificationChannelHelper`등
### Manager
- 항상 내부에서 instance로 만들어서 관리되는 용도
- 내부적으로 state 혹은 information을 가지고 있어서 호출한곳에서의 상태에 따라서 관리되는 값을 변경하고 반영하는 작업을 해준다.
- 예) `RegisterStepManager`, `RegisterCarInfoConfirmManager`등


## 기타
- `import static xx.xx.xx;`는 사용하지 않는다. ([Avoid static imports](https://carlosbecker.com/posts/avoid-static-imports/))
- `try/catch`를 사용한경우, Exception에 대한 처리를 항상 넣어준다.
```kotlin
} catch (e: Exception) {
    AnalyticsUtil.logException(e);
}
```
