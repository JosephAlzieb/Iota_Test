package com.example.iota2.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
@NpmPackage(value = "@iota/identity-wasm", version = "0.6")
@JsModule("@iota/identity-wasm/web/identity_wasm.js")
//@JsModule("./testJS.js")
@JsModule("./register.js")
public class RegisterView extends VerticalLayout {

  public RegisterView() {
    TextField assetId = new TextField("Asset ID");
    TextField deviceName = new TextField("Device Name");
    TextField endpoint = new TextField("Endpoint");

    FormLayout formLayout = new FormLayout();
    formLayout.add(
        assetId, deviceName, endpoint
    );

    formLayout.setResponsiveSteps(
        new ResponsiveStep("0", 1),
        new ResponsiveStep("500px", 2)
    );
    formLayout.setColspan(assetId, 2);

    Button submit = new Button("Submit");
    submit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

    add(formLayout, submit);


    submit.addClickListener(
        event -> UI.getCurrent()
            .getPage()
            .executeJs("return register.createDid")
            .then(s-> System.out.println(s))

    );


//    submit.addClickListener(
//        event -> {
//          UI.getCurrent()
//              .getPage()
//              .executeJs("return com.testJ()")
//              .then(r -> System.out.println(r.asString()));
//        }
//
//    );

  }
}
