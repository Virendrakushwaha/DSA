package DesignPattern.CreationalDesignPattern;

/*I_UI_Factory (interface)
   ├── WindowUIFactory ──creates──> WindowButton, WindowModal, WindowScreen
   ├── MacUIFactory     ──creates──> MacButton, MacModal, MacScreen
   └── LinuxFactory      ──creates──> LinuxButton (Modal/Screen broken)

UIRender ──depends on──> I_UI_Factory (interface only)
IButton / IModal / IScreen (interfaces only)*/

/*The dependency direction is the key insight: UIRender depends only on interfaces (abstractions),
never on concrete classes (WindowButton, etc.). This is the Dependency Inversion Principle
in action — high-level code (UIRender)doesn't depend on low-level details (WindowButton);
both depend on abstractions (IButton).*/

//Layer 1: The Products (what gets built)
//1.Button 2.Modal 3.Screen for Windows,Mac and Linux
interface IButton{
    void renderButton();
}

interface IModal{
    void renderModal();
}

interface IScreen{
    void renderScreen();
}

//concrete class for above products
class WindowsButton implements IButton{

    @Override
    public void renderButton() {
        System.out.println("render window button");
    }
}
class WindowsModal implements IModal{

    @Override
    public void renderModal() {
        System.out.println("render window modal");
    }
}
class WindowsScreen implements IScreen{

    @Override
    public void renderScreen() {
        System.out.println("render window screen");
    }
}


class MacButton implements IButton{

    @Override
    public void renderButton() {
        System.out.println("render mac button");
    }
}
class MacModal implements IModal{

    @Override
    public void renderModal() {
        System.out.println("render mac modal");
    }
}
class MacScreen implements IScreen{

    @Override
    public void renderScreen() {
        System.out.println("render mac screen");
    }
}


class LinuxButton implements IButton{

    @Override
    public void renderButton() {
        System.out.println("render linux button");
    }
}
class LinuxModal implements IModal{

    @Override
    public void renderModal() {
        System.out.println("render linux modal");
    }
}
class LinuxScreen implements IScreen{

    @Override
    public void renderScreen() {
        System.out.println("render linux screen");
    }
}

//Layer 2: The Abstract Factory (the "family creator")
interface I_UI_Factory{
    IButton getButton();
    IModal getModal();
    IScreen getScreen();
}

class WindowFactory implements I_UI_Factory{

    @Override
    public IButton getButton() {
        return new WindowsButton();
    }

    @Override
    public IModal getModal() {
        return new WindowsModal();
    }

    @Override
    public IScreen getScreen() {
        return new WindowsScreen();
    }
}

class MacFactory implements I_UI_Factory{

    @Override
    public IButton getButton() {
        return new MacButton();
    }

    @Override
    public IModal getModal() {
        return new MacModal();
    }

    @Override
    public IScreen getScreen() {
        return new MacScreen();
    }
}

class LinuxFactory implements I_UI_Factory{

    @Override
    public IButton getButton() {
        return new LinuxButton();
    }

    @Override
    public IModal getModal() {
        throw new UnsupportedOperationException("linux does not support modal");
    }

    @Override
    public IScreen getScreen() {
        throw new UnsupportedOperationException("linux does not support screen");
    }
}

//Layer 3: The Client (who actually uses this)
class UIRender{
    IButton button;
    IModal modal;
    IScreen screen;

    UIRender(I_UI_Factory factory){
        this.button = factory.getButton();
        this.modal = factory.getModal();
        this.screen = factory.getScreen();
        renderUI();
    }

    void renderUI(){
        button.renderButton();
        modal.renderModal();
        screen.renderScreen();
    }

    void toggleUI(I_UI_Factory iUiFactory){
        this.button = iUiFactory.getButton();
        this.modal = iUiFactory.getModal();
        this.screen = iUiFactory.getScreen();
        renderUI();
    }
}

public class AbstractFactoryDesignPattern {
    static void main() {
        UIRender uiRender = new UIRender(new WindowFactory());
        uiRender.toggleUI(new LinuxFactory());
    }

}
