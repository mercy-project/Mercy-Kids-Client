# Resource 네이밍 가이드
프로젝트의 리소스 네이밍 가이드. 불가피한 경우가 아니라면 반드시 이 가이드를 따라주세요.

## Layout Filename
- `<CATEGORY>_<WHERE>_(<WHAT>)` 의 구조로 네이밍.
- 기본적으로 모든 띄어쓰기는 `_` 로 구분한다.
	- `where` 에 해당하는 단어가 `Send Message` 라면, 실제 id는 `send_message` 로 작성한다.
- `<WHAT>` 은 optional.

#### `category` : **무슨 종류의 레이아웃 인가?**
| prefix | explain |
|--|--|
| `activity_` | Activity 레이아웃 |
| `fragment_` | Fragment 레이아웃 |
| `dialog_` | Dialog에서 쓰이는 레이아웃(BottomSheetDialogFragment 포함) |
| `view_` | CustomView 레이아웃 |
| `item_` | RecyclerView 내부의 ViewHolder 레이아웃 |
| `layout_` | `<include>` 태그로 재사용할 수 있도록 작성한 공통 layout |
- 이 분류에 속하지 않는 애매한 레이아웃을 작성해야 한다면, Github Issue 를 통해 새로운 네이밍 규칙을 지정한다.

#### `where` : **어느 서비스에 사용되는가?**
- 예시
	1. `activity_login` : 로그인 화면
	2. `fragment_video_suggest` : 영상 추천 화면
	3. `fragment_search_result` : 검색 결과 화면
- DataBinding 라이브러리를 사용하게 되면 변수 이름이 과하게 길어질 수 있으니, underscore 제외 레이아웃 파일 이름의 총 길이는 **40자를 넘지 않도록 작성.**

####  `what` : **(Optional) 무슨 역할을 하는가**
- 만약 같은 서비스에 같은 종류의 레이아웃이 여러개가 있어 추가적인 구분이 필요하다면, 그 레이아웃이 하는 역할을 기준으로 추가적인 postfix를 달아준다.
- 예시
	1. `item_search_result_header` : 검색 결과 화면 - 헤더 ViewHolder
	2. `item_search_result_image` : 검색 결과 화면 - 이미지 컨텐츠 ViewHolder
	3. `item_search_result_text` : 검색 결과 화면 - 텍스트 컨텐츠 ViewHolder
	4. `item_search_result_footer` : 검색 결과 화면 - 푸터 ViewHolder
- **코드리뷰 시 네이밍 규칙을 가장 먼저 체크.**


## View Id
-  `<CATEGORY>_<DESCRIPTION>`
- View 클래스의 대문자를 축약해서 Category의 prefix로 사용한다.

#### Category : 뷰 종류가 무엇인가?
1. Android에서 제공하는 기본 컴포넌트는 클래스의 대문자를 축약한 형태로 사용한다.
	- `AppCompat` 과 같은 정보는 무시한다.
	- 예시 : `AppCompatTextView` -> `tv_` , `CheckBox` -> `cb`
2. 기본 컴포넌트 클래스가 한 단어로 이루어져 있어 대문자가 1개만 있다면, 클래스 전체를 소문자로 사용한다.
	- 예시 : `AppCompatSwitch` -> `switch_`, `Space` -> `space_`
3. 커스텀뷰는 클래스 전체 이름을 snake_case로 사용한다.
	- 예시 : `ExpandableRecyclerView` -> `expandable_recycler_view_`
4. 이 외에 추가적인 정의가 필요하다면 Github Issue에 등록하여 협의 후 추가한다.

| View Name | Prefix |
|--|--|
| (AppCompat)TextView | `tv_` |
| (AppCompat)ImageView | `iv_` |
| (AppCompat)CheckBox | `cb_` |
| RecyclerView | `rv_` |
| (AppCompat)EditText | `et_` |
| ProgressBar | `pb_` |
| FrameLayout | `fl_` |
| View | `view_` |
| NestedScrollView | `nsv_` |
| SwipeRefreshLayout | `srl_` |
| Switch | `switch_` |
| SpecialCustomView | `special_custom_view_` |


#### Description : 어디에 사용되는 뷰인가
- 해당 뷰의 기능을 간략히 표현

#### 예시
- 닫기 버튼용 ImageView : `tv_close`
- 영상 리스트 RecyclerView : `rv_video_list`


## Drawable Filename
- `<WHAT>(_<WHERE>)_<DESCRIPTION>(_<SIZE>)`
- 이미지가 여러군데에서 활용될 경우, `<WHERE>`는 생략 가능
- 이미지의 크기가 1개밖에 없는 경우, `<SIZE>`는 생략 가능

#### What
| Prefix | 설명 |
| ------------- | ------------- |
| `ic_` | 일반 이미지 or 아이콘 |
| `bg_` | 백그라운드 |
| `img_` | 실제사진이거나 아이콘형태가 아닌 일러스트형태의 이미지 |
| `div_` | divider로 활용되는 이미지 |
| `shadow_` | (권장하지 않음) 그림자 나인패치 이미지 |

#### Selector
- 배경이나 버튼에서 View의 상태에 따라서 drawable이 변해야 하는 경우에 대한 이름은 아래와 같다.

| 상태 | Suffix |
| ------------- | ------------- |
| Normal | `_normal` |
| Pressed | `_pressed` |
| Focused | `_focused` |
| Disabled | `_disabled` |
| Selected | `_selected` |


#### Background
- 배경색이 여러 케이스에 대해 동적으로 바뀌어야 한다면, Selector를 쓰거나 CustomView로 구현한다.
- Radius 값만을 조절하기 위한 용도로 Drawable을 사용하지 않는다.
	- CardView를 사용하면 클릭 시 리플 효과 등 여러 케이스에 유연하게 대응할 수 있다.
- `<COLOR>(_<STROKE>)` 의 형태로 표기한다.
	- `COLOR` : `#123456` 에서 `#`을 뗀 6자리 string을 표기한다. 만약 백그라운드가 그라데이션을 사용한다면, `GRADIENT` 로 표기한다.
		- 예시 : `bg_123456` : `#123456`의 색을 가진 백그라운드 드로어블
	- `STROKE` : 테두리 옵션이 있다면, `stroke` 태그의 `width` 값을 적어준다.
		- 예시 : `bg_123456_2dp` : `#123456` 의 색을 가지고, width 2dp의 stroke을 가진 백그라운드 드로어블

#### Others
- `img_xxx`의 경우 파일의 크기가 큰경우가 많으므로 [tinypng](https://tinypng.com/)에서 파일크기를 줄인뒤에 추가해 주세요.

#### 예시
- `ic_call_normal.xml`: 전화걸기 버튼 벡터 이미지
- `ic_call_pressed.xml`: 전화걸기 버튼 눌렸을때의 벡터 이미지
- `ic_call.xml`: 전화걸기 버튼 이미지의 selector xml


## Dimension

#### Margin / Padding
- 대부분의 `margin/padding`은 아래 정의된 `space_xxx`로만 사용되도록 한다.
```xml
<dimen name="space_xx_small">4dp</dimen>
<dimen name="space_x_small">8dp</dimen>
<dimen name="space_small">12dp</dimen>
<dimen name="space_median">16dp</dimen>
<dimen name="space_large">20dp</dimen>
<dimen name="space_x_large">24dp</dimen>
<dimen name="space_xx_large">28dp</dimen>
```

- 이외에 Margin/Padding에 커스터마이징이 필요한 경우, 그 때에는 직접 값을 지정한다.
```xml
android:layout_marginStart = "48dp"
android:layout_marginEnd = "48dp
```

#### Width / Height
- `ConstraintLayout` 을 쓰고 있다면, `match_parent` 대신에 Constraint를 사방에 걸어놓고 `0dp` 옵션을 사용하는 것을 사용하는 것이 좋다.


## String
-  `<WHERE>_<DESCRIPTION>`
- 특정화면에서 쓰이는 텍스트 아니라 여러군데에서 공통으로 재사용될 텍스트라면 `common_<DESCRIPTION>`로 이름을 짓는다

#### 예시
- `permission_dialog_camera_title`: 카메라권한을 요구하는 Dialog의 제목
-  `permission_dialog_camera_description`: 카메라권한을 요구하는 Dialog의 설명내용
- `common_yes`: 네
- `common_ok_understand`: 여러 Dialog에서 `네, 알겠습니다`로 쓰이는 공통의 텍스트

### 문단
- 문단형태의 긴 문자열로 개행(`\n`)이 필요한 경우, `\n`을 다음줄의 앞에 쓴다.
```xml
 <string name="sample">문단 첫번째줄
        \n문단 두번째줄
        \n문단 세번째줄</string>
```

## Attribute
- Attribute이름은 `camelCase`로 한다.
```xml
<attr name="numStars" format="integer" />
```

- 기존에 정의되어있는 `android:xxx`와 같은 동작을 유도하는 경우, 이 tag를 재사용한다.
```xml
<declare-styleable name="SpannedGridLayoutManager">
 <attr name="android:orientation" />
...
</declare-styleable>
```

## 기타
- `android:xxxLeft/android:xxxRight` 대신 `android:xxxStart/android:xxxEnd`로 사용한다. (기타 Left/Right로 사용하는 부분 모두)
