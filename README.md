# MaterialToolbar
MaterialToolbar makes it easy to build a Fragment navigation based application with fully customized toolbar views.

![Alt text](/images/demo-portrait.gif?raw=true) ![Alt text](/images/demo-landscape.gif?raw=true)

## How it works
To do this it uses a simple MVP model with presenter class called MaterialPresenter that will handle Fragment navigation 
inside a single Activity.
All you got to do is to tell the MaterialPresenter which activity will hold the fragments. 
Then wherever on the app you can call the MaterialPresenter to navigate to any Fragment.
If this Fragments implements the MaterialToolbarSupplier interface it means that this Fragment will provide a custom Toolbar
layout to interact with.

## Example
The first step is to create a single Activity and attach the activity to the singleton instance of MaterialPresenter.
First thing you got to do is to set **Theme.AppCompat.Light.NoActionBar** in your **AndroidManifest.xml** file, 
and insert your MaterialToolbar instead of standard Toolbar in your activity xml layout. The layout also must to include
a fragment container view such as this FrameLayout in which fragments will be placed


```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <es.shyri.materialtoolbar.MaterialToolbar
        android:id="@+id/main_toolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:animateLayoutChanges="true"
        android:background="?attr/colorPrimary"
        android:minHeight="?attr/actionBarSize" />

    <FrameLayout
        android:id="@+id/fragmentContainer"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:animateLayoutChanges="true" />

</LinearLayout>

```
**Note that I set the animateLayoutChanges flag in order to have smooth toolbar transitions.**
After that we can override our onCreate method of the activity to tell the MaterialPresenter instance, telling it which are 
the layout ids of the MaterialToolbar and the fragment holder views.

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = MaterialPresenter.getInstance();                // get the instance of our presenter
        
        // ATTACH the activity to the presenter telling it the id of the MaterialToolbar and the view holding the Fragments
        presenter.attachActivity(this, R.id.main_toolbar, R.id.fragmentContainer);  
        // Only if the fragment container has no fragment, we tell the MaterialPresenter to navigate to a new Fragment instance
        // This will assure the right behaviour during screen rotation and other configuration changes
        if (getFragmentManager().findFragmentById(R.id.fragmentContainer) == null) {
            presenter.navigateTo(new MyAwesomeFragment());
        }
    }
        
```

Also for roation, other configuration changes and to avoid view leaks it is necessary to detach the activity when it is going to be destroyed

```java
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachActivity();
    }
```

Finally we want to override the onBackPressed method to let the presenter handle the fragment backstack poping


```java

    @Override
    public void onBackPressed(){
        if(!presenter.onBackPressed()) super.onBackPressed();
    }

```

In your fragment you have to implement MaterialToolbarSupplier only if you want to have your custom Toolbar layout.


```java

public class MyAwesomeFragment extends Fragment implements MaterialToolbarSupplier {
  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      // [...] infalte your fragment view
      
      // This is your time to create your MaterialToolbarContent and instantiate the views.
      toolbarContent = new MaterialToolbarContent(getActivity(), R.layout.my_awesome_toolbar);
      // Tell the presenter to set the MaterialToolbarContent of this Fragment.
      presenter.getToolbar().setContent(toolbarContent);
      // Instantiate all views
      Button myAwesomeButton = toolbarContent.findViewById(R.id.myAwesomeButton);
      myAwesomeButton.findViewById(R.id.myAwesomeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.navigateTo(new OtherFragment());  // We can use the presenter this Fragment to navigate to others.
            }
        });
      // [...]
      return view;
    }
}
```
And obviously override the other MaterialToolbarSupplier methods
```java
    @Override
    public void setPresenter(MaterialPresenter presenter) {
        // get the presenter instance, you can use it later for navigate to children Fragments.
        this.presenter = presenter;
    }
    
    @Override
    public MaterialToolbarContent getToolbarContent() {
        // This will allow the presenter to set the MaterialToolbarContent when user navigates back to 
        // this Fragment or during configuration changes
        return toolbarContent;
    }
```

## Download
MaterialToolbar is available through jcenter()
```gradle

dependencies {
    compile 'es.shyri:materialtoolbar:0.1.1'
}
```
License
-------

    Copyright 2015 Shyri Villar

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
