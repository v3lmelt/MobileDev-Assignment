#### 项目架构

使用单MainActivity+多Fragment的MVVM架构

__codes
____models
____services
______interfaces
______implementations
____utilities
____viewmodels
____views

需要知道该架构下需要知道的内容：
1、hilt依赖注入 

    https://developer.android.google.cn/training/dependency-injection/hilt-android?hl=zh-cn

module需要放到utilities

2、dataBinding 
    
    https://developer.android.google.cn/topic/libraries/data-binding?hl=zh-cn

3、fragment navigation

    https://developer.android.google.cn/guide/navigation?hl=zh-cn

4、utilities

每个ViewModel需要继承ObservableViewModel
其中属性绑定需要类似如下设置，加@Bindable注释，手动判断属性是否相等并触发属性改变事件（java没有ref，不然可以写类似INotifyPropertyChanged的设计使用泛型的setProperty）

    @Bindable
    public String getUserName() {
        return model.getUserName();
    }

    public void setUserName(String userName) {
        if (model.getUserName().equals(userName))
            return;

        this.model.setUserName(userName);
        notifyPropertyChanged(BR.userName);
    }


每个Fragment需要继承
    
    ViewFragment<TViewModel extends ObservableViewModel, TViewDataBinding extends ViewDataBinding>

Fragment对应的Fragment___Binding是编译器根据xml自动生成，有时需要clean和rebuild

每个Activity需要继承ViewActivity(本项目因该是不需要了)，类似Fragment进行处理