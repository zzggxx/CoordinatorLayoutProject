
# CoordinatorLayout

添加依赖:
```java
compile 'com.android.support:design:24.2.1'
```
CoordinatorLayout：协调内部子控件间的滚动事件，通常作为**最外层**的布局使用，通过配置**CoordinatorLayout.Behavior**这个行为属性，可以控制其内部子控件间的联动效果，AppBarLayout和FloatingActionButton具有默认的Behavior实现

注意:

1. CorrdinatorLayout只可以捕获到实现了NestedScrollingChild接口的子view的滚动事件，然后分发给其他内部子view
    * RecyclerView
    * NestedScrollView和ScrollView一样效果，但是他可以被捕获事件
    * SwipeRefreshLayout

2. AppBarLayout中的子view是否响应滚动事件，通过给子view配置app:layout_scrollFlags属性来指定不同的滚动事件响应
    * scroll（常用） 响应滚动事件，必须配置这个属性
    * enterAlways（常用） 滚动事件向下，配置该属性的子view就会向下滚动进入
    * enterAlwaysCollapsed 滚动事件向下，子view也配置了最小高度，那么向下滚动时，子view会以最小高度进入，只有当被监听的view滚动到顶端时，子view才会以最大高度展开
    * snap 该属性会判断子view底部能看到多少，如果只能看到25%，那么缩回去，如果能看到75%，那么完全显示
    * exitUntilCollapsed（常用） 子view滚出屏幕时，待其完全折叠之后才滚动，从用在CollapsingToolbarLayout中

3. AppBarLayout中的子view需要滚动的，必须放在最顶部，否则滚不动