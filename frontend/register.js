const {AccountBuilder, ExplorerUrl} = require('@iota/identity-wasm/web')

window.register = {

  createDid : async function (){
    console.log("creating identity... This might take some time to complete POW")

    // The creation step generates a keypair, builds an identity
    // and publishes it to the IOTA mainnet.
    let builder = new AccountBuilder();
    let account = await builder.createIdentity();

    // Retrieve the DID of the newly created identity.
    let did = account.did();

    // Print the DID of the created Identity.
    console.log(did.toString())

    // Print the local state of the DID Document
    console.log(account.document());

    // Print the Explorer URL for the DID.
    console.log(`Explorer Url:`, ExplorerUrl.mainnet().resolverUrl(did));

    return account.document();
  }

}