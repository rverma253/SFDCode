from Crypto.PublicKey import RSA

# Generate RSA key pair
key = RSA.generate(2048)

# Export private and public keys
private_key = key.export_key()
public_key = key.publickey().export_key()

# Save private and public keys to files
with open('private_key.pem', 'wb') as f:
    f.write(private_key)

with open('public_key.pem', 'wb') as f:
    f.write(public_key)

print("Keys generated and saved.")
